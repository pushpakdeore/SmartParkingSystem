package com.example.smartparking.dto;

import com.example.smartparking.model.Reservation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String name;
    private String email;
    private String phone;
    private List<String> registeredVehicles;
















//    private List<Reservation> reservations;
//
//    public void setReservations(List<Reservation> reservations) {
//        this.reservations = reservations;
//    }
//
//    public List<Reservation> getReservations() {
//        return reservations;
//    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<String> getRegisteredVehicles() {
        return registeredVehicles;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setRegisteredVehicles(List<String> registeredVehicles) {
        this.registeredVehicles = registeredVehicles;
    }
}
