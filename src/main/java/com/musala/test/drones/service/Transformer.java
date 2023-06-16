package com.musala.test.drones.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.ObjectUtils;

import com.musala.test.drones.controller.request.DroneRequest;
import com.musala.test.drones.controller.request.MedicationItem;
import com.musala.test.drones.controller.response.DroneBatteryLevelResponse;
import com.musala.test.drones.controller.response.DroneResponse;
import com.musala.test.drones.controller.response.DronesResponse;
import com.musala.test.drones.controller.response.MedicationItemResponse;
import com.musala.test.drones.controller.response.MedicationItemsResponse;
import com.musala.test.drones.model.Drone;
import com.musala.test.drones.model.Medication;
import com.musala.test.drones.util.DroneModel;
import com.musala.test.drones.util.DroneState;

public interface Transformer {
	
	public static Drone createDrone(DroneRequest droneRequest) {
		DroneModel validDroneModel = null;
		for (DroneModel droneModel : DroneModel.values()) {
			if(droneModel.getValue().equals(droneRequest.getModel())) {
				validDroneModel = droneModel;
				break;
			}
		}
		
		if (ObjectUtils.isEmpty(validDroneModel)) {
			
		}

		return Drone.builder()
				.serialNumber(droneRequest.getSerialNumber())
				.model(validDroneModel)
				.weightLimit(droneRequest.getWeightLimit())
				.batteryCapacity(droneRequest.getBatteryCapacity())
				.droneState(DroneState.IDLE)
				.build();
	}

	public static DroneResponse createDroneResponse(Drone drone) {
		return DroneResponse.builder()
				.serialNumber(drone.getSerialNumber())
				.model(drone.getModel().getValue())
				.weightLimit(drone.getWeightLimit())
				.batteryCapacity(drone.getBatteryCapacity())
				.droneState(drone.getDroneState())
				.build();
	}

	public static Medication createMedication(MedicationItem MedicationItem) {
		return Medication.builder()
				.name(MedicationItem.getName())
				.weight(MedicationItem.getWeight())
				.code(MedicationItem.getCode())
				.imageURL(MedicationItem.getImageURL())
				.build();
	}

	public static MedicationItemsResponse createMedicationResponse(Drone drone ) {		
		List<MedicationItemResponse> medicationItems = new ArrayList<>();
		for (Medication medication : drone.getMedications()) {
			medicationItems.add(createMedicationItem(medication));
		}
		return MedicationItemsResponse.builder()
				.serialNumber(drone.getSerialNumber())
				.model(drone.getModel().getValue())
				.weightLimit(drone.getWeightLimit())
				.batteryCapacity(drone.getBatteryCapacity())
				.droneState(drone.getDroneState())
				.medicationItems(medicationItems)
				.build();
	}

	public static MedicationItemResponse createMedicationItem(Medication medication) {
		return MedicationItemResponse.builder()
				.id(medication.getId())
				.name(medication.getName())
				.weight(medication.getWeight())
				.code(medication.getCode())
				.imageURL(medication.getImageURL())
				.droneId(medication.getDrone().getSerialNumber())
				.build();
	}

	public static DronesResponse createDronesResponse(List<Drone> availableDrones) {		
		List<DroneResponse> drons = new ArrayList<>();
		for (Drone drone : availableDrones) {
			drons.add(createDroneResponse(drone));
		}
		
		return DronesResponse.builder()
				.drones(drons)
				.build();
	}

	public static DroneBatteryLevelResponse createBatterLevelResponse(Drone existingDrone) {
		return DroneBatteryLevelResponse.builder()
				.serialNumber(existingDrone.getSerialNumber())
				.batteryCapacity(existingDrone.getBatteryCapacity())
				.build();
	}

}
