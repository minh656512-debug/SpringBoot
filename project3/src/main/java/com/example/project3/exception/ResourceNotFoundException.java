package com.example.project3.exception;

public class ResourceNotFoundException extends AppException{
    public ResourceNotFoundException(String resourceName, String fieldName, Object fieldValue) {
        super(404, String.format("%s khong tim thay voi %s: '%s'", resourceName, fieldName, fieldValue));
    }

}
