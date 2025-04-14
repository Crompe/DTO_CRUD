package com.example.Proyecto_DTO_CRUD.Controlador;

import com.example.Proyecto_DTO_CRUD.UsuarioDto.UsuarioDto;
import com.example.Proyecto_DTO_CRUD.UsuarioService.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Api/Usuarios")
public class UsuarioControlador
{
    @RestController
    @RequestMapping("/api/usuarios")
    public class UsuarioController {

        @Autowired
        private UsuarioService usuarioService;

        // Crear un nuevo usuario
        @PostMapping
        public ResponseEntity<UsuarioDto> crearUsuario(@Valid @RequestBody UsuarioDto usuarioDto) {
            UsuarioDto nuevoUsuario = usuarioService.crearNuevoUsu(usuarioDto);
            return ResponseEntity.ok(nuevoUsuario);
        }

        // Obtener todos los usuarios
        @GetMapping
        public ResponseEntity<List<UsuarioDto>> listarUsuarios() {
            List<UsuarioDto> usuarios = usuarioService.obtenerTodosUsu();
            return ResponseEntity.ok(usuarios);
        }

        // Obtener usuario por ID
        @GetMapping("/{id}")
        public ResponseEntity<UsuarioDto> obtenerUsuarioPorId(@PathVariable Long id) {
            UsuarioDto usuario = usuarioService.obtenerUsuPorId(id);
            return ResponseEntity.ok(usuario);
        }

        // Actualizar un usuario
        @PutMapping("/{id}")
        public ResponseEntity<UsuarioDto> actualizarUsuario(@PathVariable Long id, @Valid @RequestBody UsuarioDto usuarioDto) {
            UsuarioDto usuarioActualizado = usuarioService.actualizarUsu(id, usuarioDto);
            return ResponseEntity.ok(usuarioActualizado);
        }

        // Eliminar un usuario
        @DeleteMapping("/{id}")
        public ResponseEntity<Map<String, String>> eliminarUsuario(@PathVariable Long id)
        {
            String mensaje = usuarioService.eliminarUsu(id);
            return ResponseEntity.ok(Map.of("mensaje", mensaje));
        }

    }
}
