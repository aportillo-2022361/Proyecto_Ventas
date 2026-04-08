package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Usuario;
import com.ventas.proyect.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioServiceImplements implements UsuarioService{
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImplements(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> getAllUsers() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario saveUsers(Usuario usuario) throws RuntimeException {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario updateUser(Integer id, Usuario usuario) {
        Usuario usuarioExists = usuarioRepository.findById(id).orElse(null);

        if (usuarioExists == null) {
            return null;
        }

        usuarioExists.setUsername(usuario.getUsername());
        usuarioExists.setPassword(usuario.getPassword());
        usuarioExists.setEmail(usuario.getEmail());
        usuarioExists.setRol(usuario.getRol());
        usuarioExists.setEstado(usuario.getEstado());
        usuarioExists.setCodigoUsuario(usuario.getCodigoUsuario());

        return usuarioRepository.save(usuarioExists);
    }

    @Override
    public void deleteUser(Integer id) {
        usuarioRepository.deleteById(id);
    }
}
