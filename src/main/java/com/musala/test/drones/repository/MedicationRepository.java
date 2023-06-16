package com.musala.test.drones.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.test.drones.model.Medication;

@Repository
public interface MedicationRepository extends JpaRepository<Medication, String> {

}
