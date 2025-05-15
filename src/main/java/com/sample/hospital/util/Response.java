package com.sample.hospital.util;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

@Getter
@Setter
@ToString
public class Response<T> extends ResponseEntity<Response.ResponseBody<T>> {

    public Response(HttpStatusCode status, String message, T data) {
        super(new ResponseBody<>(message, data), status);
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @ToString
    public static class ResponseBody<T> {
        private final String message;
        private final T data;

    }
}
