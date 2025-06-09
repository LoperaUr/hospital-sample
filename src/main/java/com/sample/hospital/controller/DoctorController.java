package com.sample.hospital.controller;

import com.sample.hospital.persistence.model.Doctor;
import com.sample.hospital.service.IDoctorService;
import com.sample.hospital.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/doctor")
public class DoctorController {

    private final IDoctorService doctorService;

    @PostMapping
    public Response<Doctor> saveDoctor(@RequestBody @Validated Doctor doctor) {
        Doctor savedDoctor = doctorService.saveDoctor(doctor);
        return new Response<>(HttpStatus.CREATED, "Doctor saved successfully", savedDoctor);

    }
}
