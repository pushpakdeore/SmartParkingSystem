package com.example.smartparking.service;

import com.example.smartparking.dto.ReservationDTO;
import com.example.smartparking.model.Reservation;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {
    Reservation createReservation(Long userId, Long slotId, String vehicleNumber, LocalDateTime startTime, LocalDateTime endTime);

    void cancelReservation(Long reservationId);

    List<Reservation> getUserReservations(Long userId);
}
