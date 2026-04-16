package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Usuario;
import com.ventas.proyect.Service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/lista")
    public String listarDetalles(Model model) {
        List<Usuario> lista = usuarioService.getAllUsers();
        System.out.println("Cantidad de usuarios encontrados: " + lista.size());
        model.addAttribute("Usuario", lista);
        return "Users";
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

    @GetMapping("/eliminar/{id}")
    public String deleteUser (@Valid @PathVariable Integer id) {
        usuarioService.deleteUser(id);
        return "redirect:/usuario/lista";
    }
}
