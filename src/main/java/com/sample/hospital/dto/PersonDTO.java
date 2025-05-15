package com.sample.hospital.dto;

import lombok.Data;

@Data
public class PersonDTO {

    private Long id;

    private String name;

    private String lastName;

    private boolean state;

    private boolean type;

}
