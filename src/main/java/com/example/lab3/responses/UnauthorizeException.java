package com.example.lab3.responses;

public class UnauthorizeException extends Response{
    public UnauthorizeException(String message) {
        super(401, message);
    }
}
