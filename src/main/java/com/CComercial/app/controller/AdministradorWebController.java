package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.CComercial.app.repository.*;

@Controller
@RequestMapping("/administradores")
public class AdministradorWebController {

    @Autowired
    private AdministradorRepository repository;

    @GetMapping
    public String listAdministradores(Model model) {
        model.addAttribute("administradores", repository.findAll());
        return "administradores/list";
    }

    @GetMapping("/{id}")
    public String getAdministradorById(@PathVariable String id, Model model) {
        model.addAttribute("administrador", repository.findById(id).orElse(null));
        return "administradores/detail";
    }
}
