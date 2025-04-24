package com.example.MiniProject2.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime tripDate;
    private String origin;
    private String destination;
    private Double tripCost;

    @ManyToOne
    @JoinColumn(name = "captain_id")
    private Captain captain;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;


    public Trip() {
    }

    // Partial constructor
    public Trip(LocalDateTime tripDate, String origin, String destination, Double tripCost) {
        this.tripDate = tripDate;
        this.origin = origin;
        this.destination = destination;
        this.tripCost = tripCost;
    }


}
