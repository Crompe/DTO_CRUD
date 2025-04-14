package com.example.Proyecto_DTO_CRUD.exception;

public class ValidationException extends RuntimeException
{
    public ValidationException(String message)
    {
        super(message);
    }
}
