package com.ventas.proyect.Repository;

import com.ventas.proyect.Entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsuario(String username);
}
