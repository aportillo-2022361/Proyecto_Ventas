package com.ventas.proyect.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/home")
    public String mostrarHome() {
        return "Home";
    }

    @GetMapping("/clientes")
    public String mostrarClientes() {
        return "Clientes";
    }

    @GetMapping("/detalleVenta")
    public String mostrarDetallesVentas() {
        return "DetalleVentas";
    }

    @GetMapping("/productos")
    public String mostrarProductos() {
        return "Producto";
    }

    @GetMapping("/users")
    public String mostrarUsers() {
        return "Users";
    }

    @GetMapping("/ventas")
    public String mostrarVentas() {
        return "Ventas";
    }

}
