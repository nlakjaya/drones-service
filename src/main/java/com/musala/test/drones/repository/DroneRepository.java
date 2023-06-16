package com.musala.test.drones.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.test.drones.model.Drone;
import com.musala.test.drones.util.DroneState;

@Repository
public interface DroneRepository extends JpaRepository<Drone, String> {

	Drone findDroneBySerialNumber(String serialNumber);

	List<Drone> findDroneByDroneState(DroneState droneState);

}
