package com.sample.hospital.persistence.repository;

import com.sample.hospital.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}