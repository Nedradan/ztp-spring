package com.example.lab3.responses;

public class OkResponse extends Response{

    public OkResponse() {
        super(200, "Successfully logged");
    }
    public OkResponse(Object message) {
        super(200, message);
    }
}