package com.sample.hospital.service;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.exception.AppException;
import com.sample.hospital.persistence.model.Person;
import com.sample.hospital.persistence.repository.PersonRepository;
import com.sample.hospital.util.mapper.PersonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.sample.hospital.util.HospitalUtils.validateListNotEmpty;

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
        validateListNotEmpty(persons);
        return personMapper.toDtoList(persons);
    }

    @Override
    public Person savePerson(Person person) {
        if (person == null) {
            throw new AppException("Person cannot be null", HttpStatus.BAD_REQUEST);
        }
        Optional<Person> personResult = personRepository.findByEmail(person.getEmail());
        return personResult.orElseGet(() -> personRepository.save(person));
    }


}
