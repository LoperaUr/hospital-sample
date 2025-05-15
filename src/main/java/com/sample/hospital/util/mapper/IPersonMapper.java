package com.sample.hospital.util.mapper;

import com.sample.hospital.dto.PersonDTO;
import com.sample.hospital.persistence.model.Person;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IPersonMapper {

    List<PersonDTO> personModelListToPersonDTOList(List<Person> persons);
}
