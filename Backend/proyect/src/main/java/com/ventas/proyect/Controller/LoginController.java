package com.ventas.proyect.Controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/")
    public String inicio() {
        return "redirect:/usuario";
    }

    @GetMapping("/usuario")
    public String mostrarLogin() {
        return "Login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String password, HttpSession session, Model model) {
        String userCorrecto = "admin";
        String passCorrecto = "1234";

        if (usuario.equals(userCorrecto) && password.equals(passCorrecto)) {
            session.setAttribute("usuarioLogueado", usuario);
            return "redirect:/home";
        } else {
            model.addAttribute("mensaje", "Error: Usuario o contraseña incorrecta");
            return "Login";
        }
    }

    @GetMapping("/home")
    public String mostrarProfesor(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/home";
        }
        return "Home";
    }
}
