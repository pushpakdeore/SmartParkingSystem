package com.example.smartparking.service;

import com.example.smartparking.dto.BillDTO;
import com.example.smartparking.model.Bill;
import com.example.smartparking.model.Reservation;

public interface BillService {
    Bill generateBill(Reservation reservation);

    Bill updateBillPaymentStatus(Long billId, String status);

    BillDTO getBill(Long resid);

    BillDTO payBill(Long billId);

    double revenue();

}
