package com.example.Proyecto_DTO_CRUD.convertir;

import com.example.Proyecto_DTO_CRUD.UsuarioDto.UsuarioDto;
import com.example.Proyecto_DTO_CRUD.conexionUsuario.Usuario;
import org.springframework.stereotype.Component;

@Component
public class UsuarioMapper {
    public Usuario toEntity(UsuarioDto dto) {
        Usuario usuario = new Usuario();
        usuario.setId(dto.getId());
        usuario.setNumeroDocumento(dto.getNumeroDocumento());
        usuario.setNombreUsuario(dto.getNombreUsuario());
        usuario.setApellidoUsuario(dto.getApellidoUsuario());
        usuario.setEdadUsuario(dto.getEdadUsuario());
        usuario.setTelefonoUsuario(dto.getTelefonoUsuario());
        usuario.setTipoDocumento(dto.getTipoDocumento());
        usuario.setFechaNacimiento(dto.getFechaNacimiento());
        usuario.setDireccionUsuario(dto.getDireccionUsuario());
        return usuario;
    }
    public UsuarioDto toDto(Usuario entity)
    {
        UsuarioDto dto = new UsuarioDto();
        dto.setId(entity.getId());
        dto.setNumeroDocumento(entity.getNumeroDocumento());
        dto.setNombreUsuario(entity.getNombreUsuario());
        dto.setApellidoUsuario(entity.getApellidoUsuario());
        dto.setEdadUsuario(entity.getEdadUsuario());
        dto.setTelefonoUsuario(entity.getTelefonoUsuario());
        dto.setTipoDocumento(entity.getTipoDocumento());
        dto.setFechaNacimiento(entity.getFechaNacimiento());
        dto.setDireccionUsuario(entity.getDireccionUsuario());
        return dto;
    }
}


