package com.example.getyourway.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class EndpointException extends RuntimeException{
    public EndpointException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
