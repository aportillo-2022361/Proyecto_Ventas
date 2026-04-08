package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Usuario;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UsuarioService {
    List<Usuario> getAllUsers();
    Usuario saveUsers (Usuario usuario) throws RuntimeException;
    Usuario updateUser (Integer id, Usuario usuario);
    void deleteUser (Integer id);
}
