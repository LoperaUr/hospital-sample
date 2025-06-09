package com.sample.hospital.persistence.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Nurses")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Nurse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_person", referencedColumnName = "id_person", unique = true, nullable = false)
    @ToString.Exclude
    private Person person;

    @Column(columnDefinition = "TEXT")
    private String certifications;

    @Column(name = "preferred_shift", length = 50)
    private String preferredShift;

}