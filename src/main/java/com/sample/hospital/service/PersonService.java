package com.sample.hospital.service;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.exception.AppException;
import com.sample.hospital.persistence.model.Person;
import com.sample.hospital.persistence.repository.PersonRepository;
import com.sample.hospital.util.mapper.PersonMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.sample.hospital.util.HospitalConstants.EMPTY_ERROR;

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
        validatePersonNotEmpty(persons);
        return personMapper.toDtoList(persons);
    }

    @Override
    public List<PersonDTO> getPersonsByTypeId(int typeId) {
        List<Person> persons = personRepository.findByTypeId((long) typeId);
        validatePersonNotEmpty(persons);
        return personMapper.toDtoList(persons);
    }

    private static void validatePersonNotEmpty(List<Person> persons) {
        if (persons.isEmpty()) {
            throw new AppException(EMPTY_ERROR, HttpStatus.NOT_FOUND);
        }
    }
}
