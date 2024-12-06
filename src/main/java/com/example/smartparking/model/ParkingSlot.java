package com.example.smartparking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "parkingSlot")
public class ParkingSlot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int slotNumber;
    private String level;
    private boolean isAvailable;
    private String vehicleType;















    public long getId() {
        return id;
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public String getLevel() {
        return level;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public String getVehiclesType() {
        return vehicleType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setSlotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public void setVehiclesType(String vehiclesType) {
        this.vehicleType = vehiclesType;
    }



    public String getVehicleType() {
        return vehicleType;
    }
}

