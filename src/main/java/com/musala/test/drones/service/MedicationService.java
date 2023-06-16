package com.musala.test.drones.service;

import com.musala.test.drones.controller.request.MedicationRequest;
import com.musala.test.drones.controller.response.MedicationItemsResponse;

public interface MedicationService {

	MedicationItemsResponse loadMedicationItemsToDrone(String serialNumber, MedicationRequest medicationRequest);

}
