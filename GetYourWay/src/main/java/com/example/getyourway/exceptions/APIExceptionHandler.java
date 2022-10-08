package com.example.getyourway.exceptions;

import com.stripe.exception.StripeException;
import org.springframework.dao.DataAccessException;
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

    @ExceptionHandler({ServiceException.class, StripeException.class})
    protected ResponseEntity<Object> handleServiceException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, defaultResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }

    @ExceptionHandler(InvalidDateException.class)
    protected ResponseEntity<Object> handleInvalidDateException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler({DataAccessException.class})
    protected ResponseEntity<Object> handleDataAccess(RuntimeException ex, WebRequest request) {
        final String dataAccessResponse = "Unable to process request! Check details and try again later!";
        return handleExceptionInternal(ex, dataAccessResponse, new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }
    @ExceptionHandler({UserDetailsException.class})
    protected ResponseEntity<Object> handleUserDetailsException(RuntimeException ex, WebRequest request) {
        return handleExceptionInternal(ex, ex.getMessage(), new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request);
    }


}
