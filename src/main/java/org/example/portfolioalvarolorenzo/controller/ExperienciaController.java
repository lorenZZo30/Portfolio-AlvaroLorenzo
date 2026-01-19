package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Experiencia;
import org.example.portfolioalvarolorenzo.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/experiencia")
public class ExperienciaController {

    @Autowired
    private final ExperienciaService experienciaService;

    public ExperienciaController(ExperienciaService experienciaService) {
        this.experienciaService = experienciaService;
    }

    @GetMapping
    public String listarExperiencias(Model model) {
        model.addAttribute("experiencias", experienciaService.getExperiencias());
        return "admin/experiencia-list";
    }

    @GetMapping("/new")
    public String nuevaExperiencia(Model model) {
        model.addAttribute("experiencia", new Experiencia());
        return "admin/experiencia-form";
    }

    @GetMapping("/edit/{id}")
    public String editarExperiencia(@PathVariable Long id, Model model) {
        Experiencia e = experienciaService.findById(id);
        model.addAttribute("experiencia", e);
        return "admin/experiencia-form";
    }

    @PostMapping("/save")
    public String guardarExperiencia(@ModelAttribute("experiencia") Experiencia experiencia) {
        experienciaService.save(experiencia);
        return "redirect:/admin/experiencia";
    }

    @PostMapping("/delete/{id}")
    public String eliminarExperiencia(@PathVariable Long id) {
        experienciaService.delete(id);
        return "redirect:/admin/experiencia";
    }
}
