package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Login;
import com.ventas.proyect.Repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImplements implements LoginService{
    @Autowired
    private LoginRepository loginRepository;

    @Override
    public Login registrar(String Usuario, String password) {
        if (loginRepository.findByUsuario(Usuario) != null) {
            return null;
        }

        Login u = new Login();
        u.setUsername(Usuario);
        u.setPassword(password);

        return loginRepository.save(u);
    }

    @Override
    public Login login(String Usuario, String password) {
        Login u = loginRepository.findByUsuario(Usuario);

        if(u != null && u.getPassword().equals(password)){
            return u;
        }
        return null;
    }

    @Override
    public List<Login> listar() {
        return loginRepository.findAll();
    }

    @Override
    public void eliminar(int id) {
        loginRepository.deleteById(id);
    }
}
