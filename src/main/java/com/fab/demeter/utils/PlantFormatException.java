package com.fab.demeter.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Malformed data.")
public class PlantFormatException extends PlantException {

    public PlantFormatException() {
    }

    public PlantFormatException(String message) {
        super(message);
    }

    public PlantFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
