package com.sample.hospital.service;

import com.sample.hospital.dto.DoctorDTO;
import com.sample.hospital.persistence.model.Doctor;
import com.sample.hospital.persistence.model.Person;
import com.sample.hospital.persistence.repository.DoctorRepository;
import com.sample.hospital.util.mapper.DoctorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static com.sample.hospital.util.HospitalUtils.validateListNotEmpty;

@Service
@RequiredArgsConstructor
public class DoctorService implements IDoctorService {

    private final DoctorRepository doctorRepository;
    private final IPersonService personService;
    private final DoctorMapper doctorMapper;

    @Override
    @Transactional
    public DoctorDTO saveDoctor(DoctorDTO dto) {
        Doctor model = doctorMapper.toModel(dto);
        Person person = personService.savePerson(model.getPerson());
        model.setPerson(person);

        Doctor savedDoctor = doctorRepository.save(model);

        return doctorMapper.toDto(savedDoctor);
    }

    @Override
    public List<DoctorDTO> getAllDoctors() {
        List<Doctor> doctors = doctorRepository.findAll();
        validateListNotEmpty(doctors);
        return doctorMapper.toDtoList(doctors);
    }
}
