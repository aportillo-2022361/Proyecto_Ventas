package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Usuario;
import com.ventas.proyect.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping
    public List<Usuario> getAllUser() {
        return usuarioService.getAllUsers();
    }

    @PostMapping
    public ResponseEntity<Object> createUser (@Valid @RequestBody Usuario usuario) {
        Usuario createUser = usuarioService.saveUsers(usuario);
        return new ResponseEntity<>(createUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser (@Valid @PathVariable Integer id, @RequestBody Usuario usuario) {
        Usuario updateUser = usuarioService.updateUser(id, usuario);
        return ResponseEntity.ok(updateUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser (@Valid @PathVariable Integer id) {
        usuarioService.deleteUser(id);
        return ResponseEntity.ok("Se ha eliminado el usuario exitosamente");
    }
}
