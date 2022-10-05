package com.example.getyourway.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "This user is not found")
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException(String e){
        super(e);
    }
}
