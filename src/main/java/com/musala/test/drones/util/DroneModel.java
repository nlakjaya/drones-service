package com.musala.test.drones.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum DroneModel {

	LIGHT_WEIGHT("Lightweight"),
	MIDDLE_WEIGHT("Middleweight"),
	CRUISER_WEIGHT("Cruiserweight"),
	HEAVY_WEIGHT("Heavyweight");

	private String value;

}
