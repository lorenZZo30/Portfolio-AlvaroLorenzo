package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class BasicController {
    @Autowired
    private UsuarioService usuarioService;
    @RequestMapping("")
    public String index() {
        return "index";
    }
    // Mostrar página de login
    @GetMapping("/login")
    public String login(
            @RequestParam(value = "error", required = false) String error,
            @RequestParam(value = "logout", required = false) String
                    logout,
            Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
        }
        if (logout != null) {
            model.addAttribute("message", "Has cerrado sesión correctamente");
        }
        return "login";
    }
    // Mostrar página de registro
    @GetMapping("/registro")
    public String mostrarRegistro() {
        return "registro";
    }
    // Procesar el registro
    @PostMapping("/registro")
    public String registrarUsuario(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            @RequestParam("email") String email,
            Model model) {
        try {
            // Validaciones básicas
            if (username.isEmpty() || password.isEmpty() ||
                    email.isEmpty()) {
                model.addAttribute("error", "Todos los campos son obligatorios");
                return "registro";
            }
            if (password.length() < 6) {
                model.addAttribute("error", "La contraseña debe tener al menos 6 caracteres");
                return "registro";
            }
            // Registrar el usuario
            usuarioService.registrarUsuario(username, password, email);
            // Redirigir al login con mensaje de éxito
            model.addAttribute("message", "Usuario registrado correctamente. Ya puedes iniciar sesión.");
            return "login";
        } catch (RuntimeException e) {
            model.addAttribute("error", e.getMessage());
            return "registro";
        }
    }
}
