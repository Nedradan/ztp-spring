package com.example.lab3.responses;

public class OkResponse extends Response{

    public OkResponse() {
        super(200, "Successfully logged");
    }
    public OkResponse(String message) {
        super(200, message);
    }
}