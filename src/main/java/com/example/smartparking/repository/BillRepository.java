package com.example.smartparking.repository;


import com.example.smartparking.model.Bill;
import com.example.smartparking.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BillRepository extends JpaRepository<Bill, Long> {

}


















//    Optional<Bill> findByReservation(Reservation reservation);