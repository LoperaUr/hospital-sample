package com.sample.hospital.service;

import com.sample.hospital.persistence.model.Doctor;
import com.sample.hospital.persistence.model.Person;
import com.sample.hospital.persistence.repository.DoctorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DoctorService implements IDoctorService {

    private final DoctorRepository doctorRepository;
    private final IPersonService personService;

    @Override
    @Transactional
    public Doctor saveDoctor(Doctor doctor) {
        Person personSaved = personService.savePerson(doctor.getPerson());

        doctor.setPerson(personSaved);

        return doctorRepository.save(doctor);
    }
}
