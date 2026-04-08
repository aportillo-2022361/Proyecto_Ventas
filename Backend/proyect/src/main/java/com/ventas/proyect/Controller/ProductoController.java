package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Producto;
import com.ventas.proyect.Service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping
    public List<Producto> getAllProductos() {
        return productoService.getAllProductos();
    }

    @PostMapping
    public ResponseEntity<Object> createProductos (@Valid @RequestBody Producto producto) {
        Producto createProducto = productoService.saveProductos(producto);
        return new ResponseEntity<>(createProducto, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProducto (@Valid @PathVariable Integer id, @RequestBody Producto producto) {
        Producto updateProducto = productoService.updateProductos(id, producto);
        return ResponseEntity.ok(updateProducto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProducto (@Valid @PathVariable Integer id) {
        productoService.deleteProductos(id);
        return ResponseEntity.ok("Se ha eliminado el producto");
    }
}
