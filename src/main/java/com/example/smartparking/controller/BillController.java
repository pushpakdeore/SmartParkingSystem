package com.example.smartparking.controller;

import com.example.smartparking.model.Bill;
import com.example.smartparking.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bill")
public class BillController {

    @Autowired
    private BillService billService;

    @GetMapping("/{id}")
    public Bill getBill(@PathVariable Long id){
        return billService.getBill(id);
    }

    @GetMapping("/pay/{billId}")
    public Bill payBill(@PathVariable Long billId) {
        return billService.payBill(billId);
    }
}

