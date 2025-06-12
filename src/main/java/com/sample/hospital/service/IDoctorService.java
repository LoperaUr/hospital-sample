package com.sample.hospital.service;

import com.sample.hospital.dto.DoctorDTO;

import java.util.List;

public interface IDoctorService {
    DoctorDTO saveDoctor(DoctorDTO doctor);

    List<DoctorDTO> getAllDoctors();
}
