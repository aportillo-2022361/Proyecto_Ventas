package com.ventas.proyect.Repository;

import com.ventas.proyect.Entity.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentasRepository extends JpaRepository<Ventas, Integer> {

}
