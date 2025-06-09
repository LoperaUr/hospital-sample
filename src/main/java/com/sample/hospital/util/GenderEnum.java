package com.sample.hospital.util;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GenderEnum {
    M("MALE"),
    F("FEMALE"),
    O("OTHER");

    private final String value;
}