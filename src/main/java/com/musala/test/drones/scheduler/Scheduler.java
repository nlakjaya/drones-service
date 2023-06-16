package com.musala.test.drones.scheduler;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.musala.test.drones.model.Drone;
import com.musala.test.drones.model.DroneBatteryLevelHistory;
import com.musala.test.drones.repository.DroneBatteryLevelHistoryRepository;
import com.musala.test.drones.repository.DroneRepository;
import com.musala.test.drones.util.DroneState;

@Component
public class Scheduler {

	@Autowired
	private DroneRepository droneRepository;

	@Autowired
	private DroneBatteryLevelHistoryRepository droneBatteryLevelHistoryRepository;

	/**
	 * This scheduler is responsible to update the battery level if the drone is at
	 * IDEL state for every minute battery level is increasing 2% if the drone is at
	 * any other state for every minute battery level is decreasing 1%
	 * 
	 * This runs every minute
	 */
	@Scheduled(cron = "0 * * * * *") // run every minute
	@Transactional
	public void runDroneBatteryScheduler() {
		List<Drone> drones = droneRepository.findAll();
		for (Drone drone : drones) {
			if (drone.getDroneState().equals(DroneState.IDLE)) {
				drone.setBatteryCapacity(Math.min(drone.getBatteryCapacity() + 2, 100));
			} else {
				drone.setBatteryCapacity(Math.max(drone.getBatteryCapacity() - 1, 0));
			}

		}
		droneRepository.saveAll(drones);
	}

	/**
	 * This scheduler is responsible to add batter level to the drone battery level
	 * history table
	 * 
	 * This runs every 5 minutes
	 */
	@Scheduled(cron = "0 */5 * * * *")
	@Transactional
	public void runAuditScheduler() {
		List<Drone> drones = droneRepository.findAll();
		List<DroneBatteryLevelHistory> history = new ArrayList<>();
		for (Drone drone : drones) {
			DroneBatteryLevelHistory droneBatteryLevelHistory = DroneBatteryLevelHistory.builder()
					.serialNumber(drone.getSerialNumber()).batteryLevel(drone.getBatteryCapacity())
					.createdDate(new Date()).build();
			history.add(droneBatteryLevelHistory);
		}
		droneBatteryLevelHistoryRepository.saveAll(history);
	}

	/**
	 * This scheduler is responsible to delete all the history records older than
	 * two days
	 * 
	 * This run once per day at midnight
	 */
	@Scheduled(cron = "0 0 0 * * *")
	@Transactional
	public void deleteOldRecords() {
		LocalDate twoDaysAgo = LocalDate.now(ZoneId.systemDefault()).minusDays(2);
		Date date = Date.from(twoDaysAgo.atStartOfDay(ZoneId.systemDefault()).toInstant());
		droneBatteryLevelHistoryRepository.deleteByCreatedDateBefore(date);
	}

	/**
	 * This scheduler is responsible to make all drones with LOADED state to
	 * DELIVERING state within 5 minutes of medication loading
	 * 
	 * This runs for every 5 minutes
	 */
	@Scheduled(cron = "0 */5 * * * *")
	@Transactional
	public void scheduleMedicationDelivery() {
		List<Drone> drons = droneRepository.findDroneByDroneState(DroneState.LOADED);
		for (Drone drone : drons) {
			drone.setDroneState(DroneState.DELIVERING);
		}
		droneRepository.saveAll(drons);
	}

	/**
	 * This scheduler is responsible to make all drones with DELIVERING state to
	 * DELIVERED state after 30 minutes of maximum delivery time
	 * 
	 * This runs for every 30 minutes
	 */
	@Scheduled(cron = "0 */30 * * * *")
	@Transactional
	public void scheduleUnloadingMedications() {
		List<Drone> drons = droneRepository.findDroneByDroneState(DroneState.DELIVERING);
		for (Drone drone : drons) {
			drone.setDroneState(DroneState.DELIVERED);
		}
		droneRepository.saveAll(drons);
	}

	/**
	 * This scheduler is responsible to make all drones with DELIVERED state to
	 * RETURNING state after 5 minutes of maximum waiting time
	 * 
	 * This runs for every 5 minutes
	 */
	@Scheduled(cron = "0 */5 * * * *")
	@Transactional
	public void scheduleDroneReturning() {
		List<Drone> drons = droneRepository.findDroneByDroneState(DroneState.DELIVERED);
		for (Drone drone : drons) {
			drone.setDroneState(DroneState.RETURNING);
		}
		droneRepository.saveAll(drons);
	}

	/**
	 * This scheduler is responsible to make all drones with RETURNING state to IDEL
	 * state after 30 minutes of maximum returning time
	 * 
	 * This runs for every 30 minutes
	 */
	@Scheduled(cron = "0 */30 * * * *")
	@Transactional
	public void scheduleReturnedDronesToIdle() {
		List<Drone> drons = droneRepository.findDroneByDroneState(DroneState.RETURNING);
		for (Drone drone : drons) {
			drone.setDroneState(DroneState.IDLE);
		}
		droneRepository.saveAll(drons);
	}

}
