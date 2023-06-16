package com.musala.test.drones.controller.request;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

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
public class DroneRequest {

	@NotNull(message = "Serial Number must not be null")
	@NotBlank(message = "Serial Number must not be empty")
	@Size(max = 100, message = "Serial number cannot exceed 100 characters")
	private String serialNumber;

	@NotNull(message = "Model Number must not be null")
	@NotBlank(message = "Model Number must not be empty")
	private String model;

	@DecimalMin(value = "0.0", inclusive = true, message = "Weight limit must be a non-negative value")
	@DecimalMax(value = "500.0", inclusive = true, message = "Weight limit must not be greater than 500")
	private Double weightLimit;

	@Range(min = 0, max = 100, message = "Battery capacity must be 0 or 100")
	private Integer batteryCapacity;

}
