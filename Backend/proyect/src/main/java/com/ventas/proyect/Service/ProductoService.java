package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {
    List<Producto> getAllProductos();
    Producto saveProductos (Producto producto) throws RuntimeException;
    Producto updateProductos (Integer id, Producto producto);
    void deleteProductos (Integer id);
}
