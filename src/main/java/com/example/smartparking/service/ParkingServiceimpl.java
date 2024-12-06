package com.example.smartparking.service;

import com.example.smartparking.exception.ReservationConflictException;
import com.example.smartparking.exception.SlotUnavailableException;
import com.example.smartparking.model.ParkingSlot;
import com.example.smartparking.repository.ParkingSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParkingServiceimpl implements ParkingService {

    @Autowired
    private ParkingSlotRepository parkingSlotRepository;

    @Override
    public ParkingSlot addSlot(ParkingSlot parkingSlot) {
        return parkingSlotRepository.save(parkingSlot);
    }

    @Override
    public List<ParkingSlot> getallSlots() {
        return parkingSlotRepository.findAll();
    }

    @Override
    public ParkingSlot getSlotById(long id) {
        return parkingSlotRepository.findById(id).orElseThrow(() -> new SlotUnavailableException("Slot not available"));
    }

    @Override
    public ParkingSlot reservationParking(long id) {
        ParkingSlot parking =  getSlotById(id);
        parking.setAvailable(false);
        parkingSlotRepository.save(parking);
        return parking;

    }

    @Override
    public ParkingSlot releaseParkingSlot(long id) {
        ParkingSlot parking  = getSlotById(id);
        parking.setAvailable(true);
        parkingSlotRepository.save(parking);
        return parking;
    }

}
