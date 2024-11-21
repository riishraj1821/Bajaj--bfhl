package com.example.demo.model;

public class GetResponse {
    private int operation_code;

    public GetResponse(int operation_code) {
        this.operation_code = operation_code;
    }

    public int getOperation_code() {
        return operation_code;
    }
}
