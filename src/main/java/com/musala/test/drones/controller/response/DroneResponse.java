package com.musala.test.drones.controller.response;

import com.musala.test.drones.util.DroneState;

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
public class DroneResponse {
	private String serialNumber;
	private String model;
	private Double weightLimit;
	private Integer batteryCapacity;
	private DroneState droneState;
}
