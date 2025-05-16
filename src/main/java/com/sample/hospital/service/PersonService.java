package com.sample.hospital.service;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.persistence.model.Person;
import com.sample.hospital.persistence.repository.PersonRepository;
import com.sample.hospital.util.mapper.PersonMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    private final PersonMapper personMapper;
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository,
                         PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public List<PersonDTO> getAllPersons() {
        List<Person> persons = personRepository.findAll();
        return personMapper.toDtoList(persons);
    }
}
