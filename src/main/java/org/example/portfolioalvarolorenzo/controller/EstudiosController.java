package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Estudios;
import org.example.portfolioalvarolorenzo.service.EstudiosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/estudios")
public class EstudiosController {

    @Autowired
    private final EstudiosService estudiosService;

    public EstudiosController(EstudiosService estudiosService) {
        this.estudiosService = estudiosService;
    }

    @GetMapping
    public String listarEstudios(Model model) {
        model.addAttribute("estudios", estudiosService.findAll());
        return "admin/estudios-list";
    }

    @GetMapping("/new")
    public String nuevoEstudio(Model model) {
        model.addAttribute("estudios", new Estudios());
        return "admin/estudios-form";
    }

    @GetMapping("/edit/{id}")
    public String editarEstudio(@PathVariable Long id, Model model) {
        Estudios e = estudiosService.findById(id);
        model.addAttribute("estudios", e);
        return "admin/estudios-form";
    }

    @PostMapping("/save")
    public String guardarEstudio(@ModelAttribute("estudios") Estudios estudio) {
        estudiosService.save(estudio);
        return "redirect:/admin/estudios";
    }

    @PostMapping("/delete/{id}")
    public String eliminarEstudio(@PathVariable Long id) {
        estudiosService.delete(id);
        return "redirect:/admin/estudios";
    }
}
