package RestourantRezervation.Restaurant.dtos;

import RestourantRezervation.Restaurant.entities.Reservation;

import lombok.Data;

import java.util.List;

@Data
public class CustomerDto {

    private int id;

    private String name;

    private String surName;

    private String phoneNumber;

    private String email;

    private List<Reservation> reservations;


}

