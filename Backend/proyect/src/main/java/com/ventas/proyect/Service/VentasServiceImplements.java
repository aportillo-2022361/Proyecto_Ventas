package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Ventas;
import com.ventas.proyect.Repository.VentasRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasServiceImplements implements VentasService{
    private final VentasRepository ventasRepository;

    public VentasServiceImplements(VentasRepository ventasRepository) {
        this.ventasRepository = ventasRepository;
    }

    @Override
    public List<Ventas> getAllSales() {
        return ventasRepository.findAll();
    }

    @Override
    public Ventas saveSales(Ventas ventas) throws RuntimeException {
        return ventasRepository.save(ventas);
    }

    @Override
    public Ventas updateSales(Integer id, Ventas ventas) {
        Ventas ventasExists = ventasRepository.findById(id).orElse(null);

        if (ventasExists == null) {
            return null;
        }

        ventasExists.setClientesDpiCliente(ventas.getClientesDpiCliente());
        ventasExists.setCodigoVenta(ventas.getCodigoVenta());
        ventasExists.setEstado(ventas.getEstado());
        ventasExists.setFechaVenta(ventas.getFechaVenta());
        ventasExists.setTotal(ventas.getTotal());
        ventasExists.setUsuariosCodigoUsuario(ventas.getUsuariosCodigoUsuario());

        return ventasRepository.save(ventasExists);
    }

    @Override
    public void deleteSales(Integer id) {

    }
}
