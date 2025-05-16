package com.sample.hospital.persistence.repository;

import com.sample.hospital.persistence.model.PersonType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonTypeRepository extends JpaRepository<PersonType, Long> {
    boolean existsByType(PersonType.Type type);
}