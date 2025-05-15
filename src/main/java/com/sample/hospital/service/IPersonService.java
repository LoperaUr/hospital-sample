package com.sample.hospital.service;

import com.sample.hospital.dto.PersonDTO;

import java.util.List;

public interface IPersonService {

    List<PersonDTO> getAllPersons();
}
