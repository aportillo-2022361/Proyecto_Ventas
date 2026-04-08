package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Clientes;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ClientesService {
    List<Clientes> getAllClients();
    Clientes saveClients (Clientes clientes) throws RuntimeException;
    Clientes updatedClients (Integer id, Clientes clientes);
    void deleteClients (Integer id);
}
