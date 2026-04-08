package com.ventas.proyect.Repository;

import com.ventas.proyect.Entity.Clientes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Integer> {
    
}
