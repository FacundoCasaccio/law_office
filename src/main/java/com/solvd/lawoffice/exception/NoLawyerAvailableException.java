package com.solvd.lawoffice.exception;

public class NoLawyerAvailableException extends RuntimeException{
    public NoLawyerAvailableException(String message) {
        super(message);
    }
}
