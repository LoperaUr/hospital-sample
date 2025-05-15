package com.sample.hospital.service;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.persistence.model.Person;
import com.sample.hospital.persistence.repository.PersonRepository;
import com.sample.hospital.util.mapper.IPersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService{

    private final IPersonMapper personMapper;
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository, IPersonMapper iPersonMapper) {
        this.personRepository = personRepository;
        this.personMapper = iPersonMapper;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return personMapper.personModelListToPersonDTOList(persons);
    }
}
