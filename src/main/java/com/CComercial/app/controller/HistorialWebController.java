package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.CComercial.app.variables.Historialdecompra;
import com.CComercial.app.repository.HistorialdecompraRepository;

@Controller
@RequestMapping("/historial")
public class HistorialWebController {

    @Autowired
    private HistorialdecompraRepository historialdecompraRepository;

    // Mostrar todo el historial de compras
    @GetMapping
    public String listHistorial(Model model) {
        model.addAttribute("historiales", historialdecompraRepository.findAll());
        return "listahistorial"; // Apunta a la vista Thymeleaf listahistorial.html
    }

    // Mostrar formulario para agregar un nuevo historial
    @GetMapping("/nuevo")
    public String showNewHistorialForm(Model model) {
        model.addAttribute("historial", new Historialdecompra());
        return "nuevohistorial"; // Apunta a la vista Thymeleaf nuevohistorial.html
    }

    // Guardar un nuevo historial
    @PostMapping
    public String saveHistorial(@ModelAttribute Historialdecompra historial) {
        historialdecompraRepository.save(historial);
        return "redirect:/historial";
    }

    // Mostrar formulario para editar un historial
    @GetMapping("/editar/{id}")
    public String showEditHistorialForm(@PathVariable String id, Model model) {
        Historialdecompra historial = historialdecompraRepository.findById(id).orElse(null);
        model.addAttribute("historial", historial);
        return "editarhistorial"; // Apunta a la vista Thymeleaf editarhistorial.html
    }

    // Actualizar un historial existente
    @PostMapping("/editar/{id}")
    public String updateHistorial(@PathVariable String id, @ModelAttribute Historialdecompra historial) {
        historial.setId(id);
        historialdecompraRepository.save(historial);
        return "redirect:/historial";
    }

    // Eliminar un historial
    @GetMapping("/eliminar/{id}")
    public String deleteHistorial(@PathVariable String id) {
        historialdecompraRepository.deleteById(id);
        return "redirect:/historial";
    }
}
