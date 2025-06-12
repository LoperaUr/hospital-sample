package com.sample.hospital.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DoctorDTO {

    private Long id;

    @Valid
    private PersonDTO person;

    @NotBlank(message = "Specialty cannot be blank")
    @Size(max = 25, min = 3, message = "Specialty must be between 3 and 25 characters")
    private String specialty;

    @NotBlank(message = "License number cannot be blank")
    @Size(max = 20, min = 5, message = "License number must be between 5 and 20 characters")
    private String licenseNumber;


}
