package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.CComercial.app.repository.*;

@Controller
@RequestMapping("/empleados")
public class EmpleadoWebController {

    @Autowired
    private EmpleadoRepository repository;

    @GetMapping
    public String listEmpleados(Model model) {
        model.addAttribute("empleados", repository.findAll());
        return "empleados/list";
    }

    @GetMapping("/{id}")
    public String getEmpleadoById(@PathVariable String id, Model model) {
        model.addAttribute("empleado", repository.findById(id).orElse(null));
        return "empleados/detail";
    }
}
