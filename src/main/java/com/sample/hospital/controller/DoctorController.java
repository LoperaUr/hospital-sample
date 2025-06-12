package com.sample.hospital.controller;

import com.sample.hospital.dto.DoctorDTO;
import com.sample.hospital.service.IDoctorService;
import com.sample.hospital.util.Response;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sample.hospital.util.HospitalConstants.RESOURCE_CREATED_SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final IDoctorService doctorService;

    @PostMapping
    public Response<DoctorDTO> saveDoctor(@RequestBody @Valid DoctorDTO dto) {
        DoctorDTO savedDoctor = doctorService.saveDoctor(dto);
        return new Response<>(HttpStatus.CREATED, RESOURCE_CREATED_SUCCESS, savedDoctor);
    }

    @GetMapping
    public Response<List<DoctorDTO>> getAllDoctors() {
        List<DoctorDTO> doctorResult = doctorService.getAllDoctors();
        return new Response<>(HttpStatus.OK, "Doctors retrieved successfully", doctorResult);
    }
}
