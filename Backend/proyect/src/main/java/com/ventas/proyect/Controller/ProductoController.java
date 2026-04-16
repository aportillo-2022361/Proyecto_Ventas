package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Producto;
import com.ventas.proyect.Service.ProductoService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/producto")
public class ProductoController {
    private final ProductoService productoService;

    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    @GetMapping("/lista")
    public String listarDetalles(Model model) {
        List<Producto> lista = productoService.getAllProductos();
        System.out.println("Cantidad de productos encontrados: " + lista.size());
        model.addAttribute("Productos", lista);
        return "Producto";
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

    @GetMapping("/eliminar/{id}")
    public String deleteProducto (@Valid @PathVariable Integer id) {
        productoService.deleteProductos(id);
        return "redirect:/producto/lista";
    }
}
