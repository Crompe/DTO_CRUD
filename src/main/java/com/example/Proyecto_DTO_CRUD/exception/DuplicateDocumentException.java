package com.example.Proyecto_DTO_CRUD.exception;

public class DuplicateDocumentException extends RuntimeException
{
    public DuplicateDocumentException(String numeroDocumento)
    {
        super("Ya existe un usuario registrado con el número de documento: " + numeroDocumento);
    }
}
