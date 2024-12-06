package com.example.smartparking.controller;

import com.example.smartparking.model.ParkingSlot;
import com.example.smartparking.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
    private ParkingService parkingSlotService;


    @PostMapping ("/add")
    public ParkingSlot  addslot(@RequestBody ParkingSlot parkingSlot){
        return parkingSlotService.addSlot(parkingSlot);
    }

    @GetMapping("/{id}")
    public ParkingSlot getSlotById(@PathVariable long id){
        return  parkingSlotService.getSlotById(id);
    }

    @GetMapping("/all")
    public List<ParkingSlot> getallslots(){
        return  parkingSlotService.getallSlots();
    }

    @PutMapping("/reserve/{id}")
    public ParkingSlot reserveParkingSlot(@PathVariable long id ){
        return parkingSlotService.reservationParking(id);
    }

    @PutMapping("/release/{id}")
    public ParkingSlot releaseParkingSlot(@PathVariable long id){
        return parkingSlotService.releaseParkingSlot(id);
    }
}

