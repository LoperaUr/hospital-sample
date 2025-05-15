package com.sample.hospital.controller;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.service.IPersonService;
import com.sample.hospital.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/person")
public class PersonController {

    private final IPersonService personService;

    @GetMapping("/")
    public Response<List<PersonDTO>> getAllPersons() {
        var personResult = personService.getAllPersons();
        return new Response<>(HttpStatus.OK, "", personResult);
    }
}
