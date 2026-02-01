package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Contacto;
import org.example.portfolioalvarolorenzo.service.EmailService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/contacto")
public class ContactoController {

    private final EmailService emailService;

    public ContactoController(EmailService emailService) {
        this.emailService = emailService;
    }

    // Mostrar formulario
    @GetMapping
    public String mostrarFormulario(Model model) {
        model.addAttribute("contacto", new Contacto());
        return "contacto"; // ✅ ahora SÍ
    }

    // Procesar formulario
    @PostMapping("/enviar")
    public String enviar(@ModelAttribute Contacto contacto, Model model) {

        try {
            String cuerpo =
                    "Nombre: " + contacto.getNombre() + "\n" +
                            "Datos de contacto: " + contacto.getCorreo() + "\n\n" +
                            "Mensaje:\n" + contacto.getMensaje();

            emailService.enviarCorreoContacto(cuerpo);

            model.addAttribute("mensajeExito", "¡Mensaje enviado correctamente!");
            model.addAttribute("contacto", new Contacto());

        } catch (Exception e) {
            model.addAttribute("mensajeError", "No se pudo enviar el mensaje. Inténtalo más tarde.");
            model.addAttribute("contacto", contacto);
        }

        return "contacto";
    }

}