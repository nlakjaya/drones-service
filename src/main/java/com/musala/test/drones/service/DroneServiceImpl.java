package com.musala.test.drones.service;

import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.musala.test.drones.controller.request.DroneRequest;
import com.musala.test.drones.controller.response.DroneBatteryLevelResponse;
import com.musala.test.drones.controller.response.DroneResponse;
import com.musala.test.drones.controller.response.DronesResponse;
import com.musala.test.drones.controller.response.MedicationItemsResponse;
import com.musala.test.drones.exception.DroneNotFoundException;
import com.musala.test.drones.exception.ExistingDroneException;
import com.musala.test.drones.model.Drone;
import com.musala.test.drones.repository.DroneRepository;
import com.musala.test.drones.util.DroneState;
import com.musala.test.drones.util.Message;

@Service
public class DroneServiceImpl implements DroneService {

	@Autowired
	private DroneRepository droneRepository;

	@Override
	public DroneResponse registerDrone(DroneRequest droneRequest) {
		Drone existingDrone = droneRepository.findDroneBySerialNumber(droneRequest.getSerialNumber());
		if (!ObjectUtils.isEmpty(existingDrone)) {
			String description = String.format("drone has already been created for the [ %s ] serial number",
					droneRequest.getSerialNumber());
			throw new ExistingDroneException(Message.DRONE_FOUND.getDescription(), description, HttpStatus.BAD_REQUEST);
		}
		Drone drone = Transformer.createDrone(droneRequest);
		Drone registeredDrone = droneRepository.save(drone);
		return Transformer.createDroneResponse(registeredDrone);
	}

	@Override
	public MedicationItemsResponse getMedicationItems(String serialNumber) {
		Drone existingDrone = droneRepository.findDroneBySerialNumber(serialNumber);
		if (ObjectUtils.isEmpty(existingDrone)) {
			String description = String.format("drone not found for the [ %s ] serial number", serialNumber);
			throw new DroneNotFoundException(Message.DRONE_NOT_FOUND.getDescription(), description,
					HttpStatus.BAD_REQUEST);
		}
		return Transformer.createMedicationResponse(existingDrone);
	}

	@Override
	public DronesResponse getAvailableDrones() {
		List<Drone> availableDrones = droneRepository.findDroneByDroneState(DroneState.IDLE);
		return Transformer.createDronesResponse(availableDrones);
	}

	@Override
	public DroneBatteryLevelResponse getBatteryLevel(String serialNumber) {
		Drone existingDrone = droneRepository.findDroneBySerialNumber(serialNumber);
		if (ObjectUtils.isEmpty(existingDrone)) {
			String description = String.format("drone not found for the [ %s ] serial number", serialNumber);
			throw new DroneNotFoundException(Message.DRONE_NOT_FOUND.getDescription(), description,
					HttpStatus.BAD_REQUEST);
		}
		return Transformer.createBatterLevelResponse(existingDrone);
	}

}
