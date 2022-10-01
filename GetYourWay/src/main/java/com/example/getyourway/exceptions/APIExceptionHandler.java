package com.example.getyourway.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

        @ExceptionHandler(RuntimeException.class)
        protected ResponseEntity<Object> handleConflict(RuntimeException ex, WebRequest request) {
            String bodyOfResponse = "These arguments are not valid";
            return handleExceptionInternal(ex, bodyOfResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
        }

}
