package com.musala.test.drones.controller.request;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class MedicationItem {

	@NotBlank(message = "Name must not be empty")
	@NotNull(message = "Name must not be null")
	@Pattern(regexp = "^[a-zA-Z0-9_-]+$", message = "Name can only contain letters, numbers, hyphens, and underscores")
	private String name;

	@DecimalMin(value = "0.0", inclusive = true, message = "Weight must be a non-negative value")
	private Double weight;

	@Pattern(regexp = "^[A-Z0-9_]+$", message = "Code can only contain uppercase letters, underscores, and numbers")
	private String code;

	private String imageURL;

}
