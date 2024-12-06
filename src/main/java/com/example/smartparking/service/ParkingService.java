package com.example.smartparking.service;

import com.example.smartparking.model.ParkingSlot;

import java.util.List;

public interface  ParkingService {
    List<ParkingSlot> getallSlots();

    ParkingSlot addSlot(ParkingSlot parkingSlot);

    ParkingSlot reservationParking( long id);

    ParkingSlot getSlotById(long id);

    ParkingSlot releaseParkingSlot(long parkingSlot);

}
