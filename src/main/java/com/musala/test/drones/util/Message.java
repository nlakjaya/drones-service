package com.musala.test.drones.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public enum Message {

	DRONE_FOUND("Drone Found"), 
	DRONE_NOT_FOUND("Drone Not Found"),
	DRONE_STATE_IS_NOT_IDLE("Drone State Is Not IDLE"),
	EXCEED_WEIGHT_LIMIT("Exceeds Weight Limit"),
	DRONE_BATTERY_LOW("Drone Battery Low"),
	INVALID_REQUEST("Invalid Request");

	private String description;

}
