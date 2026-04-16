package com.ventas.proyect.Controller;

import com.ventas.proyect.Entity.Login;
import com.ventas.proyect.Service.LoginService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class LoginController {

    @Autowired
    private LoginService service;

    @GetMapping("/usuario")
    public String mostrarLogin() {
        return "Login";
    }

    @PostMapping("/login")
    public String validar(@RequestParam("username") String username,
            @RequestParam("password") String password,
            HttpSession session,
            Model model) {

        System.out.println("Intentando login con: " + username); // Debug
        Login l = service.login(username, password);

        // Instrucciones: En dado caso la DB no llegara a conectar con el usuario

        /*
         * if (usuario.equals("admin") && password.equals("123")) {
         * // Esto simula que la DB nos dio el OK
         * session.setAttribute("isAdmin", true);
         * return "redirect:/home";
         * }
         */

        if (l != null) {
            session.setAttribute("isAdmin", l.getAdmin());
            System.out.println("Login exitoso para: " + l.getUsername()); // Debug
            session.setAttribute("usuarioLogueado", l);
            return "redirect:/home";
        } else {
            System.out.println("Login fallido: Usuario no encontrado"); // Debug
            model.addAttribute("error", "Credenciales incorrectas");
            return "Login";
        }
    }

    // REGISTRO
    @GetMapping("/registro")
    public String registro() {
        return "Registro";
    }

    @PostMapping("/registro")
    public String guardar(@RequestParam String username,
            @RequestParam String password,
            @RequestParam Boolean isAdmin,
            Model model) {

        Login login = service.registrar(username, password, isAdmin);

        if (login == null) {
            model.addAttribute("error", "Usuario ya existe");
            return "Registro";
        }

        return "redirect:/usuario";
    }

    // LISTA
    @GetMapping("/lista")
    public String listar(Model model) {
        List<Login> lista = service.listar();
        model.addAttribute("usuarios", lista);
        return "lista";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable int id) {
        service.eliminar(id);
        return "redirect:/lista";
    }

    @GetMapping("/home")
    public String mostrarHome(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "Home";
    }

    @GetMapping("/clientes")
    public String mostrarClientes(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "Clientes";
    }

    @GetMapping("/detalleVenta")
    public String mostrarDetallesVentas(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "DetalleVentas";
    }

    @GetMapping("/productos")
    public String mostrarProductos(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "Producto";
    }

    @GetMapping("/users")
    public String mostrarUsers(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "Users";
    }

    @GetMapping("/ventas")
    public String mostrarVentas(HttpSession session) {
        if (session.getAttribute("usuarioLogueado") == null) {
            return "redirect:/usuario";
        }
        return "Ventas";
    }
}
