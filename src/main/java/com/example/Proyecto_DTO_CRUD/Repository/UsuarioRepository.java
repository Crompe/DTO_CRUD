package com.example.Proyecto_DTO_CRUD.Repository;

import com.example.Proyecto_DTO_CRUD.conexionUsuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<Usuario,Long>
{
    Optional<Usuario> findByNumeroDocumento(String numeroDocumento);

}
