package com.example.smartparking.repository;

import com.example.smartparking.model.ParkingSlot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParkingSlotRepository extends JpaRepository<ParkingSlot, Long> {

}


























//List<ParkingSlot> findByIsAvailableTrue();
//
//List<ParkingSlot> findByLevelAndVehicleType(String level, String vehicleType);