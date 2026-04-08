package com.ventas.proyect.Controller;

import org.springframework.web.bind.annotation.GetMapping;

public class HomeController {

    @GetMapping("/home")
    public String mostrarProfesor() {
        return "Home";
    }

}
