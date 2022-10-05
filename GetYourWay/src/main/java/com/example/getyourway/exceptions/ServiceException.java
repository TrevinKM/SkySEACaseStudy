package com.example.getyourway.exceptions;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ServiceException extends RuntimeException {
    public ServiceException(String errorMessage) {
        super(errorMessage);
    }

    public ServiceException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
