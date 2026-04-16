package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.DetalleVenta;
import com.ventas.proyect.Service.DetalleVentaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/detalleventa")
public class DetalleVentaController {
    private final DetalleVentaService detalleVentaService;

    public DetalleVentaController(DetalleVentaService detalleVentaService) {
        this.detalleVentaService = detalleVentaService;
    }

    @GetMapping("/lista")
    public String listarDetalles(Model model) {
        List<DetalleVenta> lista = detalleVentaService.getAllDetalleVenta();
        System.out.println("Cantidad de detalles encontrados: " + lista.size());
        model.addAttribute("DetalleVenta", lista);
        return "DetalleVentas";
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

    @GetMapping("/eliminar/{id}")
    public String deleteDetalleVenta (@Valid @PathVariable Integer id) {
        detalleVentaService.deleteDetalleVenta(id);
        return "redirect:/detalleventa/lista";
    }
}
