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

    @Column(nullable = false, length = 25)
    private String specialty;

    @Column(name = "license_number", unique = true, nullable = false, length = 20)
    private String licenseNumber;
}