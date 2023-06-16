package com.musala.test.drones.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "medication")
@Entity
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Medication {

	@Id
	@GeneratedValue(generator = "uuid2")
	@GenericGenerator(name = "uuid2", strategy = "uuid2")
	@Column(name = "id", length = 36)
	private String id;

	@Column(name = "name")
	private String name;

	@Column(name = "weight")
	private Double weight;

	@Column(name = "code")
	private String code;

	@Column(name = "imageURL")
	private String imageURL;

	@ManyToOne(optional = false)
	@JoinColumn(name = "drone_id")
	private Drone drone;

}
