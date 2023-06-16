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
public class MedicationItemResponse {

	private String id;
	private String name;
	private Double weight;
	private String code;
	private String imageURL;
	private String droneId;

}
