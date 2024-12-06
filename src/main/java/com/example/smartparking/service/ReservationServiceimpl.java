package com.example.smartparking.service;

import com.example.smartparking.dto.ReservationDTO;
import com.example.smartparking.exception.ReservationConflictException;
import com.example.smartparking.exception.UserNotFoundException;
import com.example.smartparking.model.Bill;
import com.example.smartparking.model.ParkingSlot;
import com.example.smartparking.model.Reservation;
import com.example.smartparking.model.User;
import com.example.smartparking.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ReservationServiceimpl implements ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private ParkingService parkingService;

    @Autowired
    private BillService billService;

    @Autowired
    private UserService userService;

    @Override
    public Reservation createReservation(Long userId, Long slotId, String vehicleNumber, LocalDateTime startTime, LocalDateTime endTime) {
        ParkingSlot slot = parkingService.getSlotById(slotId);
        if (!slot.isAvailable()) {
            throw new ReservationConflictException("Parking slot is not available");
        }

        User user = userService.getUserById(userId);
        Reservation reservation = new Reservation();
        reservation.setParkingSlot(slot);
        reservation.setVehicleNumber(vehicleNumber);
        reservation.setStartTime(startTime);
        reservation.setEndTime(endTime);
        reservation.setStatus("Active");
        reservation.setUser (user); // Set the user in the reservation

        reservationRepository.save(reservation);
        billService.generateBill(reservation);
        parkingService.reservationParking(slotId); // Mark the slot as reserved
        return reservation;
    }

    @Override
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(() -> new ReservationConflictException("Reservation not found"));
        reservation.setStatus("Cancelled");
        reservationRepository.save(reservation);
        parkingService.releaseParkingSlot(reservation.getParkingSlot().getId());
    }

    @Override
    public List<Reservation> getUserReservations(Long userId) {
        return reservationRepository.findByUserId(userId);
    }
}



































//package com.example.smartparking.service;
//
//import com.example.smartparking.dto.ReservationDTO;
//import com.example.smartparking.exception.ReservationConflictException;
//import com.example.smartparking.exception.UserNotFoundException;
//import com.example.smartparking.model.Bill;
//import com.example.smartparking.model.ParkingSlot;
//import com.example.smartparking.model.Reservation;
//import com.example.smartparking.model.User;
//import com.example.smartparking.repository.ReservationRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.List;
//
//@Service
//public class ReservationServiceimpl implements ReservationService {
//
//    @Autowired
//    private ReservationRepository reservationRepository;
//
//    @Autowired
//    private ParkingService parkingService;
//    @Autowired
//    private BillService billService;
//
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public Reservation createReservation(Long userId, Long slotId, String vehicleNumber, LocalDateTime startTime, LocalDateTime endTime) {
//        ParkingSlot slot = parkingService.reservationParking(slotId);
//        User  u = userService.getUserById(userId);
//        Reservation reservation = new Reservation();
//       //reservation.setUser(new User(userId));
//        reservation.setParkingSlot(slot);
//        reservation.setVehicleNumber(vehicleNumber);
//        reservation.setStartTime(startTime);
//        reservation.setEndTime(endTime);
//        reservation.setStatus("Active");
//        reservationRepository.save(reservation);
//        billService.generateBill(reservation);
//        return reservation;
//    }
//
//    @Override
//    public void cancelReservation(Long reservationId) {
//        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new ReservationConflictException("Reservation not found"));
//        reservation.setStatus("Cancelled");
//        reservationRepository.save(reservation);
//        parkingService.releaseParkingSlot(reservation.getParkingSlot().getId());
//    }
//
//    @Override
//    public List<Reservation> getUserReservations(Long userId) {
//        return reservationRepository.findByUserId(userId);
//    }
//
//
//    public static ReservationDTO maptoDto(Reservation reservation){
//        ReservationDTO r = new ReservationDTO();
//        r.setUserId(reservation.getUserid(reservation.getUser()));
//        r.setId(reservation.getId());
//        r.setStatus(reservation.getStatus());
////       r.setSlotId(reservation.get);
//        r.setStartTime(reservation.getStartTime());
//        r.setEndTime(reservation.getEndTime());
//        r.setVehicleNumber(reservation.getVehicleNumber());
//        return r;
//
//
//    }
//
//}

