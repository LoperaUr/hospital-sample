package com.sample.hospital.service;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.persistence.model.Person;

import java.util.List;

public interface IPersonService {

    List<PersonDTO> getAllPersons();

    Person savePerson(Person person);
}
