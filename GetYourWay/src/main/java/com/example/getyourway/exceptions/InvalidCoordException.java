package com.example.getyourway.exceptions;

public class InvalidCoordException extends ServiceException {
    public InvalidCoordException() {
        super("Invalid latitude or longitude");
    }
}
