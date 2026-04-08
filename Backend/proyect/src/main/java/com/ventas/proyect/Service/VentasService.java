package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Ventas;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface VentasService {
    List<Ventas> getAllSales();
    Ventas saveSales (Ventas ventas) throws RuntimeException;
    Ventas updateSales (Integer id, Ventas ventas);
    void deleteSales (Integer id);
}
