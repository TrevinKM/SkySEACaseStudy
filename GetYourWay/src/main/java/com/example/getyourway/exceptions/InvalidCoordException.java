package com.example.getyourway.exceptions;

import java.security.Provider;

public class InvalidCoordException extends ServiceException {
    public InvalidCoordException(){
        super("Invalid latitude or longitude");
    }
}
