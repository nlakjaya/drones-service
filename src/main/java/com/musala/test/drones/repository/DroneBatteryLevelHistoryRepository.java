package com.musala.test.drones.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.musala.test.drones.model.DroneBatteryLevelHistory;

@Repository
public interface DroneBatteryLevelHistoryRepository extends JpaRepository<DroneBatteryLevelHistory, String> {

	void deleteByCreatedDateBefore(Date createdDate);

}
