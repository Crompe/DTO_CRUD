package com.example.Proyecto_DTO_CRUD.exception;

public class InvalidDataException extends RuntimeException
{
    public InvalidDataException(String message) {
        super(message);
    }
}
