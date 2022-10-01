package com.example.getyourway.exceptions;

public class EndpointException extends RuntimeException{
    public EndpointException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
