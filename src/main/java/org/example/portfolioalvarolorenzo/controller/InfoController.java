package org.example.portfolioalvarolorenzo.controller;

import org.example.portfolioalvarolorenzo.model.Info;
import org.example.portfolioalvarolorenzo.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/info")
public class InfoController {

    @Autowired
    private InfoService infoService;

    // Mostrar formulario (crear o editar)
    @GetMapping("/form")
    public String formInfo(Model model) {
        Info info = infoService.getInfo();

        if (info == null) {
            info = new Info();
        }

        model.addAttribute("info", info);
        return "admin/info-form";
    }

    // Guardar info
    @PostMapping("/save")
    public String saveInfo(@ModelAttribute("info") Info info) {
        infoService.save(info);
        return "redirect:/admin";
    }
}
