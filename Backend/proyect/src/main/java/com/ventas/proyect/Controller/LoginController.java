package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Login;
import com.ventas.proyect.Entity.Usuario;
import com.ventas.proyect.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/usuario")
    public String mostrarLogin() {
        return "Login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam String username, @RequestParam String password, Model model) {

        Login l = service.login(username, password);

        if (l != null) {
            return "redirect:/lista";
        } else {
            model.addAttribute("error", "Credenciales incorrectas");
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
