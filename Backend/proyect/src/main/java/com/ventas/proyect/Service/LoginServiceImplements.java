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
    public Login registrar(String username, String password) {
        if (loginRepository.findByUsername(username) != null) {
            return null;
        }

        Login u = new Login();
        u.setUsername(username);
        u.setPassword(password);

        return loginRepository.save(u);
    }

    @Override
    public Login login(String username, String password) {
        Login u = loginRepository.findByUsername(username);

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
