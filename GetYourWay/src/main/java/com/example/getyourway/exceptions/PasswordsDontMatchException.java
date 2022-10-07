package com.example.getyourway.exceptions;

public class PasswordsDontMatchException extends ServiceException {
    public PasswordsDontMatchException() {
        super("Incorrect password");
    }
}
