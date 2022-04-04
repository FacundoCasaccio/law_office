package com.solvd.law_office.exception;

public class NoLawyerAvailableException extends RuntimeException{
    public NoLawyerAvailableException(String message) {
        super(message);
    }
}
