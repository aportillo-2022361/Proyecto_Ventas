package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Ventas;
import com.ventas.proyect.Service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping
    public List<Ventas> getAllSales() {
        return ventasService.getAllSales();
    }

    @PostMapping
    public ResponseEntity<Object> createSales (@Valid @RequestBody Ventas ventas) {
        Ventas createSales = ventasService.saveSales(ventas);
        return new ResponseEntity<>(createSales, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateSales (@Valid @PathVariable Integer id, Ventas ventas) {
        Ventas updateSales = ventasService.updateSales(id, ventas);
        return ResponseEntity.ok(updateSales);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSales (@Valid @PathVariable Integer id) {
        ventasService.deleteSales(id);
        return ResponseEntity.ok("Se ha eliminado la venta exitosamente");
    }
}
