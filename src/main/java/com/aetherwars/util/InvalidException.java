package com.aetherwars.util;

public class InvalidException extends Exception{
    private final String message;

    public InvalidException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}