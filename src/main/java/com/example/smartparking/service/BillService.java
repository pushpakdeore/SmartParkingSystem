package com.example.smartparking.service;

import com.example.smartparking.model.Bill;
import com.example.smartparking.model.Reservation;

public interface BillService {
    Bill generateBill(Reservation reservation);

    Bill updateBillPaymentStatus(Long billId, String status);

    Bill getBill(Long resid);

    Bill payBill(Long billId);
}
