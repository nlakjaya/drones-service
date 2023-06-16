package com.musala.test.drones.service;

import com.musala.test.drones.controller.request.DroneRequest;
import com.musala.test.drones.controller.response.DroneBatteryLevelResponse;
import com.musala.test.drones.controller.response.DroneResponse;
import com.musala.test.drones.controller.response.DronesResponse;
import com.musala.test.drones.controller.response.MedicationItemsResponse;

public interface DroneService {

	DroneResponse registerDrone(DroneRequest droneRequest);

	MedicationItemsResponse getMedicationItems(String serialNumber);

	DronesResponse getAvailableDrones();

	DroneBatteryLevelResponse getBatteryLevel(String serialNumber);

}
