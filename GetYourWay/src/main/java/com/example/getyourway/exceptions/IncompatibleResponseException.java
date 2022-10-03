package com.example.getyourway.exceptions;

public class IncompatibleResponseException extends ServiceException {
    public IncompatibleResponseException(String message, Exception e){
        super(message, e);
    }

    public IncompatibleResponseException(String message){
        super(message);
    }
    public IncompatibleResponseException(){
        super("Unable to parse JSON response to entity");
    }

}
