package com.sample.hospital.controller;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.service.IPersonService;
import com.sample.hospital.util.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/by-type")
    public Response<List<PersonDTO>> getPersonsByTypeId(
            @RequestParam() int typeId
    ) {
        var persons = personService.getPersonsByTypeId(typeId);
        return new Response<>(HttpStatus.OK, SUCCESS, persons);
    }
}
