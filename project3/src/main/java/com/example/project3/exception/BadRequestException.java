package com.example.project3.exception;

public class BadRequestException extends AppException{
    public BadRequestException(String message) {
        super(400, message);
    }
}
