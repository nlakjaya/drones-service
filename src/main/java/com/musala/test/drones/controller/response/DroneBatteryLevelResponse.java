package com.musala.test.drones.controller.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DroneBatteryLevelResponse {

	private String serialNumber;
	private Integer batteryCapacity;

}
