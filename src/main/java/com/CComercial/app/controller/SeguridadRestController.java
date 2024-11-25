package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.CComercial.app.repository.*;
import com.CComercial.app.variables.*;

@Controller
@RequestMapping("/admin/seguridad")
public class SeguridadRestController {

    @Autowired
    private SeguridadRepository repository;

    // Método para mostrar todos los registros de seguridad
    @GetMapping
    public String listSeguridad(Model model) {
        model.addAttribute("seguridad", repository.findAll());
        return "listSeguridad"; // Asegúrate de que esta ruta esté correcta
    }

    // Método para mostrar el formulario de creación
    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("seguridad", new Seguridad());
        return "formSeguridad"; // Asegúrate de que esta ruta esté correcta
    }

    // Método para guardar o actualizar seguridad
    @PostMapping("/guardar")
    public String saveSeguridad(@ModelAttribute Seguridad seguridad, RedirectAttributes redirectAttrs) {
        if (seguridad.getId() != null) {
            repository.save(seguridad);
            redirectAttrs.addFlashAttribute("mensaje", "Seguridad actualizada exitosamente");
        } else {
            repository.save(seguridad);
            redirectAttrs.addFlashAttribute("mensaje", "Seguridad guardada exitosamente");
        }
        return "redirect:/admin/seguridad";
    }

    // Método para mostrar el formulario de edición
    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Seguridad seguridad = repository.findById(id).orElse(null);
        if (seguridad != null) {
            model.addAttribute("seguridad", seguridad);
            return "editar-seguridad"; // Asegúrate de que esta ruta esté correcta
        }
        return "redirect:/admin/seguridad"; // Si la seguridad no existe, redirige a la lista
    }

    // Método para eliminar un registro de seguridad
    @GetMapping("/eliminar/{id}")
    public String deleteSeguridad(@PathVariable String id, RedirectAttributes redirectAttrs) {
        Seguridad seguridad = repository.findById(id).orElse(null);
        if (seguridad != null) {
            repository.deleteById(id);
            redirectAttrs.addFlashAttribute("mensaje", "Seguridad eliminada exitosamente");
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Seguridad no encontrada");
        }
        return "redirect:/admin/seguridad";
    }
}
