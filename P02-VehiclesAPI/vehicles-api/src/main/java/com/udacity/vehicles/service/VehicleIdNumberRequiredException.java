package com.udacity.vehicles.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY, reason = "The Vehicle Identification Number is required for a car")
public class VehicleIdNumberRequiredException extends RuntimeException{

    public VehicleIdNumberRequiredException() {
    }

    public VehicleIdNumberRequiredException(String message) {
        super(message);
    }
}
