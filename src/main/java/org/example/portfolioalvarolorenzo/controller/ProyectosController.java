package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Proyecto;
import org.example.portfolioalvarolorenzo.service.LenguajeService;
import org.example.portfolioalvarolorenzo.service.ProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/admin/proyectos")
public class ProyectosController {
    @Autowired
    private ProyectoService proyectoService;

    @Autowired
    private LenguajeService lenguajeService;

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("proyectos", proyectoService.findAll());
        return "admin/proyecto-list";
    }

    @GetMapping("/new")
    public String nuevoProyecto(Model model) {
        model.addAttribute("proyecto", new Proyecto());
        model.addAttribute("lenguajes", lenguajeService.findAll());
        model.addAttribute("accion", "nuevo");
        return "admin/proyecto-form";
    }

    @GetMapping("/edit/{id}")
    public String editarProyecto(@PathVariable Long id, Model model, RedirectAttributes redirectAttributes) {
        try {
            Proyecto proyecto = proyectoService.getById(id);
            model.addAttribute("proyecto", proyecto);
            model.addAttribute("lenguajes", lenguajeService.findAll());
            model.addAttribute("accion", "editar");
            return "admin/proyecto-form";
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al cargar el proyecto: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "danger");
            return "redirect:/admin/proyectos";
        }
    }

    @PostMapping("/save")
    public String guardar(@ModelAttribute Proyecto proyecto,
                          @RequestParam(required = false) List<Long> lenguajesIds,
                          RedirectAttributes redirectAttributes) {
        try {
            // Guardar proyecto
            Proyecto proyectoGuardado = proyectoService.save(proyecto);

            // Asignar lenguajes
            if (lenguajesIds != null && !lenguajesIds.isEmpty()) {
                proyectoService.asignarLenguajes(proyectoGuardado.getId(), lenguajesIds);
            }

            redirectAttributes.addFlashAttribute("mensaje", "Proyecto guardado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al guardar: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "danger");
        }
        return "redirect:/admin/proyecto";
    }

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable Long id, RedirectAttributes redirectAttributes) {
        try {
            proyectoService.delete(id);
            redirectAttributes.addFlashAttribute("mensaje", "Proyecto eliminado exitosamente");
            redirectAttributes.addFlashAttribute("tipo", "success");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("mensaje", "Error al eliminar: " + e.getMessage());
            redirectAttributes.addFlashAttribute("tipo", "danger");
        }
        return "redirect:/admin/proyecto";
    }
}
