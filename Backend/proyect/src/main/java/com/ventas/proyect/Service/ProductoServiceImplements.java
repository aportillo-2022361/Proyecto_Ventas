package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Producto;
import com.ventas.proyect.Repository.ProductoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoServiceImplements implements ProductoService {
    private final ProductoRepository productoRepository;

    public ProductoServiceImplements(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public List<Producto> getAllProductos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto saveProductos(Producto producto) throws RuntimeException {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProductos(Integer id, Producto producto) {
        Producto productoExist = productoRepository.findById(id).orElse(null);

        if (productoExist == null) {
            return null;
        }

        productoExist.setCodigoProducto(producto.getCodigoProducto());
        productoExist.setEstado(producto.getEstado());
        productoExist.setNombreProducto(producto.getNombreProducto());
        productoExist.setPrecio(producto.getPrecio());
        productoExist.setStock(producto.getStock());

        return productoRepository.save(productoExist);

    }

    @Override
    public void deleteProductos(Integer id) {
        productoRepository.deleteById(id);
    }
}
