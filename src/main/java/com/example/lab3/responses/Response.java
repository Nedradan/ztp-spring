package com.example.lab3.responses;

public abstract class Response {
    private Object message;
    private int status;

    public int getStatus() {
        return status;
    }

    public Object getMessage() {
        return message;
    }

    public void setStatus(int status) {
        this.status=status;
    }

    public void setMessage(Object message) {
        this.message=message;
    }

    public Response(int status, Object message) {
        this.status = status;
        this.message = message;
    }

}

