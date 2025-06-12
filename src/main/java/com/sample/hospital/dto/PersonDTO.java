package com.sample.hospital.dto;

import com.sample.hospital.util.GenderEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;


@Setter
@Getter
public class PersonDTO {

    private Long id;

    @Size(max = 30, message = "First name cannot exceed 30 characters")
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @Size(max = 30, message = "Last name cannot exceed 30 characters")
    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    private LocalDate dateOfBirth;

    @NotNull(message = "Gender cannot be null")
    private GenderEnum gender;

    @Size(min = 1, max = 100, message = "Address must be between 1 and 100 characters")
    @NotBlank(message = "Address cannot be blank")
    private String address;

    @Size(min = 10, max = 15, message = "Phone number must be between 10 and 15 characters")
    @NotBlank(message = "Phone number cannot be blank")
    private String phoneNumber;

    @Email
    private String email;

}
