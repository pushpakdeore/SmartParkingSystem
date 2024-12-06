package com.example.smartparking.service;

import com.example.smartparking.exception.CustomException;
import com.example.smartparking.model.Bill;
import com.example.smartparking.model.Reservation;
import com.example.smartparking.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;

@Service
public class BillServiceimpl implements BillService {
    @Autowired
    private BillRepository billRepository;

    @Override
    public Bill generateBill(Reservation reservation) {
        double amount = 0;
        String vehicleType = reservation.getParkingSlot().getVehicleType();
        long duration = Duration.between(reservation.getStartTime(), reservation.getEndTime()).toHours();

        if (vehicleType.equals("Car")) {
            amount = duration * 3;
        } else if (vehicleType.equals("Bike")) {
            amount = duration * 1;
        } else if (vehicleType.equals("Truck")) {
            amount = duration * 5;
        }

        Bill bill = new Bill();
        bill.setReservation(reservation);
        bill.setAmount(amount);
        bill.setPaymentStatus("Unpaid");
        return billRepository.save(bill);
    }

    @Override
    public Bill updateBillPaymentStatus(Long billId, String status) {
        Bill bill = billRepository.findById(billId).orElseThrow(() -> new CustomException("Bill not found"));
        bill.setPaymentStatus(status);
        return billRepository.save(bill);
    }

    @Override
    public Bill getBill(Long resid) {
        return billRepository.findById(resid).orElseThrow(() -> new CustomException("Bill is not generated yet"));
    }

    @Override
    public Bill payBill(Long billId) {
        Bill bill = billRepository.findById(billId).orElseThrow(() -> new CustomException("BillID not found"));
        bill.setPaymentStatus("paid");

        return billRepository.save(bill);
    }
//@Autowired
//private BillRepository billRepository;
//
//    @Override
//    public Bill generateBill(Reservation reservation) {
//        if (reservation == null || reservation.getParkingSlot() == null) {
//            throw new CustomException("Invalid reservation or parking slot data");
//        }
//
//        double amount = 0;
//        String vehicleType = reservation.getParkingSlot().getVehicleType();
//        long duration = Duration.between(reservation.getStartTime(), reservation.getEndTime()).toHours();
//
//        // Validate duration
//        if (duration <= 0) {
//            throw new CustomException("Invalid duration for billing");
//        }
//
//        // Calculate amount based on vehicle type
//        switch (vehicleType) {
//            case "Car":
//                amount = duration * 3;
//                break;
//            case "Bike":
//                amount = duration * 1;
//                break;
//            case "Truck":
//                amount = duration * 5;
//                break;
//            default:
//                throw new CustomException("Unsupported vehicle type: " + vehicleType);
//        }
//
//        // Create and save the bill
//        Bill bill = new Bill();
//        bill.setReservation(reservation);
//        bill.setAmount(amount);
//        bill.setPaymentStatus("Unpaid");
//        return billRepository.save(bill);
//    }
//
//    @Override
//    public Bill updateBillPaymentStatus(Long billId, String status) {
//        Bill bill = billRepository.findById(billId).orElseThrow(() -> new CustomException("Bill not found"));
//        bill.setPaymentStatus(status);
//        return billRepository.save(bill);
//    }
//
//    @Override
//    public Bill getBill(Long resid) {
//        return billRepository.findById(resid).orElseThrow(() -> new CustomException("Bill is not generated yet"));
//    }
//
//    @Override
//    public Bill payBill(Long billId) {
//        Bill bill = billRepository.findById(billId).orElseThrow(() -> new CustomException("Bill ID not found"));
//        bill.setPaymentStatus("Paid");
//        return billRepository.save(bill);
//    }
}
