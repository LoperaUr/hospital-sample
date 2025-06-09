package com.sample.hospital.persistence.repository;

import com.sample.hospital.persistence.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, String> {
}