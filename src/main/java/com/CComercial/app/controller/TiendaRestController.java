package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.CComercial.app.repository.*;
import com.CComercial.app.variables.*;

@Controller
@RequestMapping("/admin/tiendas")
public class TiendaRestController {

    @Autowired
    private TiendaRepository repository;

    @Autowired
    private SeguridadRepository seguridadRepository;  // Inyecta el repositorio de Seguridad
    
    @GetMapping
    public String listTiendas(Model model) {
        model.addAttribute("tiendas", repository.findAll());
        return "listTiendas";  // Ruta para la vista de la lista de tiendas
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("tienda", new Tienda());
        
        // Cargar la lista de seguridades y pasarla al modelo
        model.addAttribute("seguridades", seguridadRepository.findAll());
        
        return "formTiendas";  // Ruta para el formulario de nueva tienda
    }

    @PostMapping("/guardar")
    public String saveTienda(@ModelAttribute Tienda tienda, RedirectAttributes redirectAttrs) {
        repository.save(tienda);  // Guardar o actualizar
        String mensaje = tienda.getId() != null ? "Tienda actualizada exitosamente" : "Tienda guardada exitosamente";
        redirectAttrs.addFlashAttribute("mensaje", mensaje);
        return "redirect:/admin/tiendas";  // Redirige a la lista de tiendas
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Tienda tienda = repository.findById(id).orElse(null);
        if (tienda != null) {
            model.addAttribute("tienda", tienda);
            
            // Cargar la lista de seguridades y pasarla al modelo
            model.addAttribute("seguridades", seguridadRepository.findAll());
            
            return "editar-tienda";  // Ruta para el formulario de edición de tienda
        }
        return "redirect:/admin/tiendas";  // Redirige si no se encuentra la tienda
    }

    @GetMapping("/eliminar/{id}")
    public String deleteTienda(@PathVariable String id, RedirectAttributes redirectAttrs) {
        Tienda tienda = repository.findById(id).orElse(null);
        if (tienda != null) {
            repository.deleteById(id);
            redirectAttrs.addFlashAttribute("mensaje", "Tienda eliminada exitosamente");
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Tienda no encontrada");
        }
        return "redirect:/admin/tiendas";  // Redirige a la lista de tiendas
    }
}
