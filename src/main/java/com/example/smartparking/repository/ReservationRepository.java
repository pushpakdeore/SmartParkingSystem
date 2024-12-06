package com.example.smartparking.repository;

import com.example.smartparking.model.ParkingSlot;
import com.example.smartparking.model.Reservation;
import com.example.smartparking.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUserId(Long userId);

}




























//Optional<Reservation> findByUserAndParkingSlot(User user, ParkingSlot parkingSlot);

