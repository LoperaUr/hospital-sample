package com.sample.hospital.persistence.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Patients")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", unique = true, nullable = false)
    @ToString.Exclude
    private Person person;

    @Column(name = "medical_history", columnDefinition = "TEXT")
    private String medicalHistory;

    @Column(columnDefinition = "TEXT")
    private String allergies;

    @Column(name = "blood_type", length = 5)
    private String bloodType;

    @Column(name = "registration_date", nullable = false)
    private LocalDateTime registrationDate;
}