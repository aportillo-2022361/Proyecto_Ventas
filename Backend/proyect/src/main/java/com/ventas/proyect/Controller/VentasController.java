package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Ventas;
import com.ventas.proyect.Service.VentasService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/ventas")
public class VentasController {
    private final VentasService ventasService;

    public VentasController(VentasService ventasService) {
        this.ventasService = ventasService;
    }

    @GetMapping("/lista")
    public String listarDetalles(Model model) {
        List<Ventas> lista = ventasService.getAllSales();
        System.out.println("Cantidad de ventas encontrados: " + lista.size());
        model.addAttribute("Ventas", lista);
        return "Ventas";
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

    @GetMapping("/eliminar/{id}")
    public String deleteSales (@Valid @PathVariable Integer id) {
        ventasService.deleteSales(id);
        return "redirect:/ventas/lista";
    }
}
