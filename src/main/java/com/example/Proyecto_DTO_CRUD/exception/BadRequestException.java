package com.example.Proyecto_DTO_CRUD.exception;

public class BadRequestException extends RuntimeException
{
    public BadRequestException(String message)
    {
        super(message);
    }
}
