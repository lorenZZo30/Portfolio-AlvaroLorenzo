package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Lenguaje;
import org.example.portfolioalvarolorenzo.service.LenguajeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/lenguaje")
public class LenguajesController {

    @Autowired
    private LenguajeService lenguajeService;

    @GetMapping
    public String listar(Model model){
        model.addAttribute("lenguajes", lenguajeService.findAll());
        return "admin/lenguaje-list";
    }

    @GetMapping("/new")
    public String nuevoLenguaje(Model model){
        model.addAttribute("lenguaje", new Lenguaje());
        return "admin/lenguaje-form";
    }

    @GetMapping("/edit/{id}")
    public String editarLenguaje(Model model, @PathVariable Long id){
        Lenguaje l = lenguajeService.getById(id);
        model.addAttribute("lenguaje", l);
        return "admin/lenguaje-form";
    }

    @PostMapping("/save")
    public String guardarLenguaje(Lenguaje lenguaje){
        lenguajeService.save(lenguaje);
        return "redirect:/admin/lenguaje";
    }

    @PostMapping("/delete/{id}")
    public String eliminarLenguaje(@PathVariable Long id){
        lenguajeService.delete(id);
        return "redirect:/admin/lenguaje";
    }


}
