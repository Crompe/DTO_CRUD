package com.example.Proyecto_DTO_CRUD.UsuarioDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioDto
{
    private long id;
    @NotNull(message = "Este campo no puede estar vacío. ¡ES OBLIGATORIO!")
    @Pattern(regexp = "\\d{1,10}", message = "El número de documento debe tener entre 1 y 10 dígitos.")
    private String numeroDocumento;
    @NotBlank(message = "El tipo de documento es obligatorio.")
    @Size(max = 10, message = "El tipo de documento no puede tener más de 10 caracteres.")
    private String tipoDocumento;
    @NotBlank(message = "El nombre es obligatorio.")
    @Size(max = 100, message = "El nombre no puede tener más de 100 caracteres.")
    private String nombreUsuario;
    @NotBlank(message = "El apellido es obligatorio.")
    @Size(max = 100, message = "El apellido no puede tener más de 100 caracteres.")
    private String apellidoUsuario;
    @Positive(message = "La edad debe ser un número positivo.")
    private int edadUsuario;
    @NotBlank(message = "El teléfono es obligatorio.")
    @Pattern(regexp = "\\d{10}", message = "El número de teléfono debe tener exactamente 10 dígitos.")
    @NotBlank(message = "El número de teléfono es obligatorio.")
    private String telefonoUsuario;
    @NotBlank(message = "La dirección es obligatoria.")
    @Size(max = 100, message = "La dirección no puede tener más de 100 caracteres.")
    private String direccionUsuario;
    @NotNull(message = "La fecha de nacimiento es obligatoria.")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date fechaNacimiento;
}
