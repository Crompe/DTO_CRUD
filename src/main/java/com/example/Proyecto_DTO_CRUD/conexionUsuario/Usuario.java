package com.example.Proyecto_DTO_CRUD.conexionUsuario;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table (name = "Usuario")
public class Usuario
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "numeroDocumento", nullable = false)
    private String numeroDocumento;
    @Column(name = "nombreUsuario", nullable = false, length = 100)
    private String nombreUsuario;
    @Column(name = "apellidoUsuario", nullable = false, length = 100)
    private String apellidoUsuario;
    @Column(name = "edadUsuario")
    private int edadUsuario;
    @Column(name = "telefonoUsuario", nullable = false, length = 20)
    private String telefonoUsuario;
    @Column(name = "tipoDocumento", nullable = false, length = 10)
    private String tipoDocumento;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(name = "fechaNacimiento", nullable = false)
    private Date fechaNacimiento;
    @Column(name= "direccionUsuario", nullable = false,length = 100)
    private String direccionUsuario;
}
