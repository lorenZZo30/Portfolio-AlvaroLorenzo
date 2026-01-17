package org.example.portfolioalvarolorenzo.controller;

import jakarta.validation.Valid;
import org.example.portfolioalvarolorenzo.model.Experiencia;
import org.example.portfolioalvarolorenzo.service.ExperienciaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/experiencia")
public class ExperienciaController {
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping
    public String listado(Model model){
        model.addAttribute("experiencias", experienciaService.getExperiencia());
        return "admin/experiencia-list";
    }

    @GetMapping("/new")
    public String nuevo(Model model){
        model.addAttribute("experiencia", new Experiencia());
        return "admin/experiencia-form";
    }

    // Método para el post mapping tras darle a guardar una nueva experiencia
    @PostMapping("/save")
    public String guardar(@Valid @ModelAttribute Experiencia experiencia,
                          BindingResult result) {
        // Si el resultado tiene errores, devuelve al formulario
        if (result.hasErrors()) {
            return "admin/experiencia-form";
        }
        // Si no, lo guarda directamente y redirije al inicio de experiencia
        experienciaService.save(experiencia);
        return "redirect:/admin/experiencia";
    }


    // Hago lo mismo para eliminar
    @PostMapping("/delete/{id}")
    public String eliminar(@PathVariable Long id) {
        experienciaService.delete(id);
        return "redirect:/admin/experiencia";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Experiencia experiencia = experienciaService.findById(id);
        if (experiencia == null) {
            return "redirect:/admin/experiencia"; // o mostrar mensaje de error
        }
        model.addAttribute("experiencia", experiencia);
        return "admin/experiencia-form";
    }
}