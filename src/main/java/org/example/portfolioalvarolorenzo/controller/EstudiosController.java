package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Estudios;
import org.example.portfolioalvarolorenzo.service.EstudiosService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/estudios")
public class EstudiosController {

    private final EstudiosService estudiosService;

    public EstudiosController(EstudiosService estudiosService) {
        this.estudiosService = estudiosService;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("estudios", estudiosService.findAll());
        return "admin/estudios-list";
    }

    @GetMapping("/new")
    public String nuevo(Model model) {
        model.addAttribute("estudios", new Estudios());
        return "admin/estudios-form";
    }

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("estudios", estudiosService.findById(id));
        return "admin/estudios-form";
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Estudios estudios) {
        estudiosService.save(estudios);
        return "redirect:/admin/estudios";
    }

    @PostMapping("/delete/{id}")
    public String eliminar(@PathVariable Long id) {
        estudiosService.delete(id);
        return "redirect:/admin/estudios";
    }
}
