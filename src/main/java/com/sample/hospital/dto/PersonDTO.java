package com.sample.hospital.dto;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PersonDTO {

    private Long id;

    private String name;

    private String lastName;

    private boolean state;

    private int typeId;

    private String typeName;

}
