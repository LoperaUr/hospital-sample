package com.sample.hospital.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "person_type")
public class PersonType {

    public enum Type {
        PATIENT,
        DOCTOR,
        NURSE,
        ADMINISTRATIVE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;

    public PersonType() {
    }

    public PersonType(Type type) {
        this.type = type;
    }

}
