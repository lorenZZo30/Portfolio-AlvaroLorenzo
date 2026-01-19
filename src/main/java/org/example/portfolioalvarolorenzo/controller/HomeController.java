package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private InfoService infoService;

    @Autowired
    private ExperienciaService experienciaService;

    @Autowired
    private EstudiosService estudiosService;

    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private LenguajeService lenguajeService;

    // Página principal
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("info", infoService.getInfo());
        model.addAttribute("experiencias", experienciaService.getExperiencias());
        model.addAttribute("estudios", estudiosService.findAll());
        model.addAttribute("proyectos", proyectoService.findAll());
        model.addAttribute("lenguajes", lenguajeService.findAll());
        return "index";
    }
}