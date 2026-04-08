package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.DetalleVenta;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleVentaService {
    List<DetalleVenta> getAllDetalleVenta();
    DetalleVenta saveDetalleVenta (DetalleVenta detalleVenta) throws RuntimeException;
    DetalleVenta updateDetalleVenta (Integer id, DetalleVenta detalleVenta);
    void deleteDetalleVenta (Integer id);
}
