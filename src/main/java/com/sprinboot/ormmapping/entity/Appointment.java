package com.sprinboot.ormmapping.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id 
    @GeneratedValue
    private Long id;

    private String time;

    @ManyToOne
    @JoinColumn(name = "doctor_id")
    private Doctor doctor;
}
