package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {
    Login registrar(String username, String password, Boolean isAdmin);
    Login login(String username, String password);
    List<Login> listar();
    void eliminar(int id);
}
