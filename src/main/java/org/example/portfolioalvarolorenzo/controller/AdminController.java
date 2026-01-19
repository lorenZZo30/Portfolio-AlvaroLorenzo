package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

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

    @GetMapping
    public String dashboard(Model model) {
        // Contar registros para mostrar en el dashboard
        model.addAttribute("totalExperiencias", experienciaService.getExperiencias().size());
        model.addAttribute("totalEstudios", estudiosService.findAll().size());
        model.addAttribute("totalProyectos", proyectoService.findAll().size());
        model.addAttribute("totalLenguajes", lenguajeService.findAll().size());
        model.addAttribute("info", infoService.getInfo());

        return "admin/dashboard";
    }
}