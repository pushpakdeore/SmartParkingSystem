package com.example.smartparking.controller;

import com.example.smartparking.dto.ReservationDTO;
import com.example.smartparking.model.Reservation;
import com.example.smartparking.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @PostMapping
    public Reservation createReservation( @RequestBody ReservationDTO reservationDTO) {
        return reservationService.createReservation(reservationDTO.getUserId(), reservationDTO.getSlotId(),
                reservationDTO.getVehicleNumber(), reservationDTO.getStartTime(), reservationDTO.getEndTime());
    }

    @DeleteMapping("/{id}")
    public void cancelReservation(@PathVariable Long id) {
        reservationService.cancelReservation(id);
    }

    @GetMapping("/user/{userId}")
    public List<Reservation> getUserReservations(@PathVariable Long userId) {
        return reservationService.getUserReservations(userId);
    }
}




























//package com.example.smartparking.controller;
//
//import com.example.smartparking.dto.ReservationDTO;
//import com.example.smartparking.model.Reservation;
//import com.example.smartparking.service.ReservationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/reservations")
//public class ReservationController {
//
//    @Autowired
//    private ReservationService reservationService;
//
//    @PostMapping
//    public Reservation createReservation(@RequestBody ReservationDTO reservationDTO) {
//        return reservationService.createReservation(reservationDTO.getUserId(), reservationDTO.getSlotId(),
//                reservationDTO.getVehicleNumber(), reservationDTO.getStartTime(), reservationDTO.getEndTime());
//    }
//
//    @DeleteMapping("/{id}")
//    public void cancelReservation(@PathVariable Long id) {
//        reservationService.cancelReservation(id);
//    }
//
//    @GetMapping("/user/{userId}")
//    public List<Reservation> getUserReservations(@PathVariable Long userId) {
//        return reservationService.getUserReservations(userId);
//    }
//}
