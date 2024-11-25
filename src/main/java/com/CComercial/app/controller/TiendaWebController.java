package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.CComercial.app.repository.*;

@Controller
@RequestMapping("/tiendas")
public class TiendaWebController {

    @Autowired
    private TiendaRepository repository;

   
    @GetMapping
    public String listTiendas(Model model) {
        model.addAttribute("tiendas", repository.findAll());
        return "tiendas/list";
    }
    

    @GetMapping("/{id}")
    public String getTiendaById(@PathVariable String id, Model model) {
        model.addAttribute("tienda", repository.findById(id).orElse(null));
        return "tiendas/detail";
    }
}
