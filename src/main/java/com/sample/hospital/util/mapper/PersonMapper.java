package com.sample.hospital.util.mapper;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.persistence.model.Person;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface PersonMapper {

    Person toEntity(PersonDTO personDTO);

    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "type.type", target = "typeName")
    PersonDTO toDto(Person person);

    @Mapping(source = "type.id", target = "typeId")
    @Mapping(source = "type.type", target = "typeName")
    List<PersonDTO> toDtoList(List<Person> person);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Person partialUpdate(PersonDTO personDTO, @MappingTarget Person person);
}