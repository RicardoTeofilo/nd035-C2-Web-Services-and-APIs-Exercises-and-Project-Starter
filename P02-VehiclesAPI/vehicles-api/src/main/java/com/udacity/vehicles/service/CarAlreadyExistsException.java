package com.udacity.vehicles.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "The Vehicle Identification Number is already registered for a car")
public class CarAlreadyExistsException extends RuntimeException{
    public CarAlreadyExistsException() {
    }

    public CarAlreadyExistsException(String message) {
        super(message);
    }
}
