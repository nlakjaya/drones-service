package com.musala.test.drones;

import com.musala.test.drones.controller.request.DroneRequest;

public final class TestDataPopulator {

	private TestDataPopulator() {
		super();
	}

	public static DroneRequest createDroneRequest() {
		DroneRequest droneRequest = new DroneRequest();
		droneRequest.setSerialNumber("fff8836e-5ee4-46d6-b1b9-65aafad6a940");
		droneRequest.setModel("Heavyweight");
		droneRequest.setWeightLimit(500.0);
		droneRequest.setBatteryCapacity(85);
		return droneRequest;
	}
}
