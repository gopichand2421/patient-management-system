package com.patientmanagement.patientservice.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.Instant;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "patient")
@Data
public class Patient {

    @jakarta.persistence.Id
    @GeneratedValue(strategy= GenerationType.UUID)
    private UUID Id;
    private String patientName;
    private String email;
    private String address;
    private String phone;

    @CreationTimestamp
    private Instant createdAt;

    @UpdateTimestamp
    private Instant updatedAt;
}
