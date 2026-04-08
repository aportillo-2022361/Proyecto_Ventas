package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.DetalleVenta;
import com.ventas.proyect.Repository.DetalleVentaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetalleVentaServiceImplements implements DetalleVentaService{
    private final DetalleVentaRepository detalleVentaRepository;

    public DetalleVentaServiceImplements(DetalleVentaRepository detalleVentaRepository) {
        this.detalleVentaRepository = detalleVentaRepository;
    }

    @Override
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaRepository.findAll();
    }

    @Override
    public DetalleVenta saveDetalleVenta(DetalleVenta detalleVenta) throws RuntimeException {
        return detalleVentaRepository.save(detalleVenta);
    }

    @Override
    public DetalleVenta updateDetalleVenta(Integer id, DetalleVenta detalleVenta) {
        DetalleVenta detalleVentaExiste = detalleVentaRepository.findById(id).orElse(null);

        if (detalleVentaExiste == null) {
            return null;
        }

        detalleVentaExiste.setCantidad(detalleVenta.getCantidad());
        detalleVentaExiste.setCodigoDetalleVenta(detalleVenta.getCodigoDetalleVenta());
        detalleVentaExiste.setPrecioUnitario(detalleVenta.getPrecioUnitario());
        detalleVentaExiste.setProductosCodigoProducto(detalleVenta.getProductosCodigoProducto());
        detalleVentaExiste.setSubtotal(detalleVenta.getSubtotal());
        detalleVentaExiste.setVentasCodigoVenta(detalleVenta.getVentasCodigoVenta());

        return detalleVentaRepository.save(detalleVentaExiste);
    }

    @Override
    public void deleteDetalleVenta(Integer id) {
        detalleVentaRepository.deleteById(id);
    }
}
