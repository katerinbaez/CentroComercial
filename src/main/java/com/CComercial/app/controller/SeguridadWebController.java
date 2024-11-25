package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.CComercial.app.repository.*;

@Controller
@RequestMapping("/seguridad")
public class SeguridadWebController {

    @Autowired
    private SeguridadRepository repository;

    @GetMapping
    public String listSeguridad(Model model) {
        model.addAttribute("seguridad", repository.findAll());
        return "seguridad/list";
    }

    @GetMapping("/{id}")
    public String getSeguridadById(@PathVariable String id, Model model) {
        model.addAttribute("seguridad", repository.findById(id).orElse(null));
        return "seguridad/detail";
    }
}
