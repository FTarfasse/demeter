package com.fab.demeter.utils;

public class PlantException extends RuntimeException {

    public PlantException() {
    }

    public PlantException(String message) {
        super(message);
    }

    public PlantException(String message, Throwable cause) {
        super(message, cause);
    }

}
