package com.sample.hospital.persistence.repository;

import com.sample.hospital.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {
    List<Person> findByTypeId(Long typeId);
}