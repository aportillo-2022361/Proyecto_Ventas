package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Clientes;
import com.ventas.proyect.Service.ClientesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
public class ClientesController {
    private final ClientesService clientesService;

    public ClientesController(ClientesService clientesService) {
        this.clientesService = clientesService;
    }

    @GetMapping
    public List<Clientes> getAllClients() {
        return clientesService.getAllClients();
    }

    @PostMapping
    public ResponseEntity<Object> createClient(@Valid @RequestBody Clientes clientes) {
        Clientes createClient = clientesService.saveClients(clientes);
        return new ResponseEntity<>(createClient, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClient(@Valid @PathVariable Integer id, @RequestBody Clientes clientes) {
        Clientes updateClient = clientesService.updatedClients(id, clientes);
        return ResponseEntity.ok(updateClient);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteClient(@Valid @PathVariable Integer id) {
        clientesService.deleteClients(id);
        return ResponseEntity.ok("Estudiante eliminado");
    }
}
