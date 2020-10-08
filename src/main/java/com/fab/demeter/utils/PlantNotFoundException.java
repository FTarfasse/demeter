package com.fab.demeter.utils;

public final class PlantNotFoundException extends RuntimeException {

    public PlantNotFoundException() {
    }

    public PlantNotFoundException(String message) {
        super(message);
    }

    public PlantNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

}
