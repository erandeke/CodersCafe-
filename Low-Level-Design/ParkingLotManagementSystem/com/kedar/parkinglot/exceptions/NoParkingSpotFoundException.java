package com.kedar.parkinglot.exceptions;

public class NoParkingSpotFoundException extends RuntimeException{

    private String message;

    public NoParkingSpotFoundException(String message)
    {
        this.message = message;
    }
}
