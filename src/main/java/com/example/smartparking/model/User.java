package com.example.smartparking.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;
    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL)
    private List<Reservation> reservations;

    @ElementCollection
    private List<String> registeredVehicles;







    public User(Long userId) {
        this.id = userId;
    }
    public User(){

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

    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }

    public void setRegisteredVehicles(List<String> registeredVehicles) {
        this.registeredVehicles = registeredVehicles;
    }

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

    public List<Reservation> getReservations() {
        return reservations;
    }

    public List<String> getRegisteredVehicles() {
        return registeredVehicles;
    }
}

