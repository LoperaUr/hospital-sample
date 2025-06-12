package com.sample.hospital.util.mapper;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.persistence.model.Person;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {

    PersonDTO toDto(Person person);

    List<PersonDTO> toDtoList(List<Person> person);

}