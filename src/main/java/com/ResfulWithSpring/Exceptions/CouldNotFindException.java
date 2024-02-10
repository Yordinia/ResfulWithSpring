package com.ResfulWithSpring.Exceptions;

public class CouldNotFindException extends RuntimeException{
    public CouldNotFindException(String message) {
        super(message);
    }
}
