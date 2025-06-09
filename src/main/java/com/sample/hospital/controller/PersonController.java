package com.sample.hospital.controller;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.service.IPersonService;
import com.sample.hospital.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.sample.hospital.util.HospitalConstants.SUCCESS;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final IPersonService personService;

    @GetMapping("/")
    public Response<List<PersonDTO>> getAllPersons() {
        var personResult = personService.getAllPersons();
        return new Response<>(HttpStatus.OK, SUCCESS, personResult);
    }

}
