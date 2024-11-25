package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.CComercial.app.variables.Estacionamiento;
import com.CComercial.app.repository.EstacionamientoRepository;

@Controller
@RequestMapping("/estacionamientos")
public class EstacionamientoWebController {

    @Autowired
    private EstacionamientoRepository estacionamientoRepository;

    @GetMapping("/AgregarEstacionamiento")
    public String showCreateEstacionamientoForm(Model model) {
        model.addAttribute("estacionamiento", new Estacionamiento());
        return "AgregarEstacionamiento";
    }

    @PostMapping("/nuevo")
    public String createEstacionamiento(@ModelAttribute Estacionamiento estacionamiento) {
        estacionamientoRepository.save(estacionamiento);
        return "redirect:/admin-dashboard";
    }

    
    @GetMapping
    public String listEstacionamientos(Model model) {
        model.addAttribute("estacionamientos", estacionamientoRepository.findAll());
        return "estacionamientos";
    }
    
    @GetMapping("/estacionamientos")
    public String showTiendas(Model model) {
        model.addAttribute("estacionamientos", estacionamientoRepository.findAll()); // Añadimos la lista de tiendas al modelo
        return "estacionamientoslist"; 
    }

    @GetMapping("/apartar/{id}")
    public String showReservarEstacionamientoForm(@PathVariable String id, Model model) {
        Estacionamiento estacionamiento = estacionamientoRepository.findById(id).orElse(null);
        model.addAttribute("estacionamiento", estacionamiento);
        return "apartar";
    }

    @PostMapping("/apartar")
    public String reservarEstacionamiento(@RequestParam String id, @RequestParam String telefono, Model model) {
        Estacionamiento estacionamiento = estacionamientoRepository.findById(id).orElse(null);
        if (estacionamiento != null && "Disponible".equalsIgnoreCase(estacionamiento.getEstado())) {
            estacionamiento.setEstado("Reservado");
            estacionamientoRepository.save(estacionamiento);

            // Añade el número de celular al modelo para confirmación
            model.addAttribute("telefono", telefono);
            model.addAttribute("estacionamiento", estacionamiento);
            return "confirmacion";
        }
        return "redirect:/estacionamientos";
    }


    @GetMapping("/editar/{id}")
    public String showEditEstacionamientoForm(@PathVariable String id, Model model) {
        Estacionamiento estacionamiento = estacionamientoRepository.findById(id).orElse(null);
        model.addAttribute("estacionamiento", estacionamiento);
        return "estacionamientos/editar";
    }

    @PostMapping("/editar/{id}")
    public String updateEstacionamiento(@PathVariable String id, @ModelAttribute Estacionamiento estacionamiento) {
        estacionamiento.setId(id);
        estacionamientoRepository.save(estacionamiento);
        return "redirect:/estacionamientos";
    }

    @GetMapping("/eliminar/{id}")
    public String deleteEstacionamiento(@PathVariable String id) {
        estacionamientoRepository.deleteById(id);
        return "redirect:/estacionamientos";
    }
}

