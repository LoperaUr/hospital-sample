package com.sample.hospital.util.mapper;

import com.sample.hospital.dto.DoctorDTO;
import com.sample.hospital.persistence.model.Doctor;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DoctorMapper {

    @Mapping(target = "id", source = "id", ignore = true)
    Doctor toModel(DoctorDTO dto);

    DoctorDTO toDto(Doctor savedDoctor);

    List<DoctorDTO> toDtoList(List<Doctor> doctors);
}

