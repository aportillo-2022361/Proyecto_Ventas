package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.DetalleVenta;
import com.ventas.proyect.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalleVenta")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping
    public List<DetalleVenta> getAllDetalleVenta() {
        return detalleVentaService.getAllDetalleVenta();
    }

    @PostMapping
    public ResponseEntity<Object> createDetalleVenta (@Valid @RequestBody DetalleVenta detalleVenta) {
        DetalleVenta createDetalleVenta = detalleVentaService.saveDetalleVenta(detalleVenta);
        return new ResponseEntity<>(createDetalleVenta, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDetalleVenta (@Valid @PathVariable Integer id, @RequestBody DetalleVenta detalleVenta) {
        DetalleVenta updateDetalleVenta = detalleVentaService.updateDetalleVenta(id, detalleVenta);
        return ResponseEntity.ok(updateDetalleVenta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDetalleVenta (@Valid @PathVariable Integer id) {
        detalleVentaService.deleteDetalleVenta(id);
        return ResponseEntity.ok("Detalle eliminado exitosamente");
    }
}
