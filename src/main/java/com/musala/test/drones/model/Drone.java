package com.musala.test.drones.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musala.test.drones.util.DroneModel;
import com.musala.test.drones.util.DroneState;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "drone")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Drone {

	@Id
	@Column(name = "id", length = 100)
	private String serialNumber;

	@Column(name = "model")
	@Enumerated(EnumType.STRING)
	private DroneModel model;

	@Column(name = "weight_limit")
	private Double weightLimit;

	@Column(name = "battery_capacity")
	private Integer batteryCapacity;

	@Column(name = "drone_state")
	@Enumerated(EnumType.STRING)
	private DroneState droneState;

	@OneToMany(mappedBy = "drone", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Medication> medications;

}
