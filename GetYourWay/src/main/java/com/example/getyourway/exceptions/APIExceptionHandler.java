package com.example.getyourway.exceptions;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class APIExceptionHandler extends ResponseEntityExceptionHandler {

    final String defaultResponse = "Something went wrong! Check your request against our documentation";
    @ExceptionHandler(ServiceException.class)
    protected ResponseEntity<Object> handleServiceException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, defaultResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    @ExceptionHandler(InvalidDateException.class)
    protected ResponseEntity<Object> handleInvalidDateException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, defaultResponse, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

}
