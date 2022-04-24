package com.example.lab3.responses;

public class BadCredentialsException extends Response{

    public BadCredentialsException() {
        super(400, "Wrong credentials!");
    }
}
