package com.example.Proyecto_DTO_CRUD.UsuarioService;

import com.example.Proyecto_DTO_CRUD.UsuarioDto.UsuarioDto;

import java.util.List;

public interface UsuarioService
{
  UsuarioDto crearNuevoUsu (UsuarioDto usuarioDto);
  List<UsuarioDto> obtenerTodosUsu ();
  UsuarioDto obtenerUsuPorId(Long id);
  UsuarioDto actualizarUsu(Long id, UsuarioDto usuarioDto);
  String eliminarUsu (Long id);
}
