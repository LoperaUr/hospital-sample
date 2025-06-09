package com.sample.hospital.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Doctors")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", unique = true, nullable = false)
    @ToString.Exclude
    private Person person;

    @Column(nullable = false)
    private String specialty;

    @Column(name = "license_number", unique = true, nullable = false)
    private String licenseNumber;
}