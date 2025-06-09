package com.sample.hospital.util;

import com.sample.hospital.exception.AppException;
import org.springframework.http.HttpStatus;

import java.util.List;

import static com.sample.hospital.util.HospitalConstants.EMPTY_ERROR;

public class Extra {

    public static void validateListNotEmpty(List<?> list) {
        if (list.isEmpty()) {
            throw new AppException(EMPTY_ERROR, HttpStatus.NOT_FOUND);
        }
    }

    private Extra() {
    }
}
