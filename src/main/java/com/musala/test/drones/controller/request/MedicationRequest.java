package com.musala.test.drones.controller.request;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Size;

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
public class MedicationRequest {

	@Valid
	@Size(min = 1, message = "At least one medication item must be present")
	private List<MedicationItem> medicationItems;

}
