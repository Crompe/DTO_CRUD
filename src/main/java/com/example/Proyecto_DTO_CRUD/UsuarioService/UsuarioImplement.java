package com.example.Proyecto_DTO_CRUD.UsuarioService;

import com.example.Proyecto_DTO_CRUD.Repository.UsuarioRepository;
import com.example.Proyecto_DTO_CRUD.UsuarioDto.UsuarioDto;
import com.example.Proyecto_DTO_CRUD.conexionUsuario.Usuario;
import com.example.Proyecto_DTO_CRUD.convertir.UsuarioMapper;
import com.example.Proyecto_DTO_CRUD.exception.DuplicateDocumentException;
import com.example.Proyecto_DTO_CRUD.exception.InvalidDataException;
import com.example.Proyecto_DTO_CRUD.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioImplement implements UsuarioService
{
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private UsuarioMapper usuarioMapper;

    @Override
    public UsuarioDto crearNuevoUsu(UsuarioDto usuarioDto)
    {
        // Validamos si ya existe un usuario con el mismo número de documento
        Optional<Usuario> usuarioExistente = usuarioRepository.findByNumeroDocumento(usuarioDto.getNumeroDocumento());
        if (usuarioExistente.isPresent())
        {
            throw new DuplicateDocumentException(usuarioDto.getNumeroDocumento());
        }
        if (usuarioDto.getEdadUsuario() <= 0)
        {
            throw new InvalidDataException("La edad debe ser mayor a 0.");
        }
        Usuario usuario = usuarioMapper.toEntity(usuarioDto);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDto(usuarioGuardado);
    }
    @Override
    public UsuarioDto obtenerUsuPorId(Long id)
    {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado."));
        return usuarioMapper.toDto(usuario);
    }
    @Override
    public List<UsuarioDto> obtenerTodosUsu()
    {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarios.stream()
                .map(usuarioMapper::toDto)
                .collect(Collectors.toList());
    }
    @Override
    public UsuarioDto actualizarUsu(Long id, UsuarioDto usuarioDto)
    {
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Usuario con ID " + id + " no encontrado."));

    Optional<Usuario> otroUsuario = usuarioRepository.findByNumeroDocumento(usuarioDto.getNumeroDocumento());
        if (otroUsuario.isPresent() && !otroUsuario.get().getId().equals(id)) {
            throw new DuplicateDocumentException("Ya existe otro usuario con el número de documento " + usuarioDto.getNumeroDocumento());
        }
        if (usuarioDto.getEdadUsuario() <= 0)
        {
            throw new InvalidDataException("La edad debe ser mayor a 0.");
        }
        usuarioExistente.setNumeroDocumento(usuarioDto.getNumeroDocumento());
        usuarioExistente.setNombreUsuario(usuarioDto.getNombreUsuario());
        usuarioExistente.setApellidoUsuario(usuarioDto.getApellidoUsuario());
        usuarioExistente.setEdadUsuario(usuarioDto.getEdadUsuario());
        usuarioExistente.setTelefonoUsuario(usuarioDto.getTelefonoUsuario());
        usuarioExistente.setTipoDocumento(usuarioDto.getTipoDocumento());
        usuarioExistente.setFechaNacimiento(usuarioDto.getFechaNacimiento());
        usuarioExistente.setDireccionUsuario(usuarioDto.getDireccionUsuario());
        Usuario usuarioActualizado = usuarioRepository.save(usuarioExistente);
        return usuarioMapper.toDto(usuarioActualizado);
    }
    @Override
    public String eliminarUsu(Long id)
    {
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No se encontró un usuario con ID: " + id));

        usuarioRepository.delete(usuario);
        return "Usuario eliminado exitosamente con ID: " + id;
    }
}
