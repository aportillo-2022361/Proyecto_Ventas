package com.ventas.proyect.Service;

import com.ventas.proyect.Entity.Clientes;
import com.ventas.proyect.Repository.ClientesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientesServiceImplements implements ClientesService {
    private final ClientesRepository clientesRepository;

    public ClientesServiceImplements(ClientesRepository clientesRepository) {
        this.clientesRepository = clientesRepository;
    }

    @Override
    public List<Clientes> getAllClients() {
        return clientesRepository.findAll();
    }

    @Override
    public Clientes saveClients(Clientes clientes) throws RuntimeException {
        return clientesRepository.save(clientes);
    }

    @Override
    public Clientes updatedClients(Integer id, Clientes clientes) {
        Clientes clienteExiste = clientesRepository.findById(id).orElse(null);

        if (clienteExiste == null) {
            return null;
        }

        clienteExiste.setNombreCliente(clientes.getNombreCliente());
        clienteExiste.setApellidoCliente(clientes.getApellidoCliente());
        clienteExiste.setDireccion(clientes.getDireccion());
        clienteExiste.setDpiCliente(clientes.getDpiCliente());
        clienteExiste.setEstado(clientes.getEstado());

        return clientesRepository.save(clienteExiste);

    }

    @Override
    public void deleteClients(Integer id) {
        clientesRepository.deleteById(id);
    }
}
