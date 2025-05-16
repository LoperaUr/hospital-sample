package com.sample.hospital.persistence.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "state")
    private boolean state;

    @ManyToOne
    @JoinColumn(name = "type_id", referencedColumnName = "id")
    private PersonType type;

}
