package com.example.lab3.responses;

public class ExceptionResponse extends Response {

    public ExceptionResponse(String message) {
        super(500, message);
    }
}
