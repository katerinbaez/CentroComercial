package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.CComercial.app.repository.*;
import com.CComercial.app.variables.*;

@Controller
@RequestMapping("/admin/empleados")
public class EmpleadoRestController {

    @Autowired
    private EmpleadoRepository repository;
    
    @Autowired
    private TiendaRepository Tiendarepository;

    @GetMapping
    public String listEmpleados(Model model) {
        model.addAttribute("empleados", repository.findAll());
        return "list";
    }

    @GetMapping("/nuevo")
    public String showCreateForm(Model model) {
        model.addAttribute("empleado", new Empleado());
        
        model.addAttribute("tiendas", Tiendarepository.findAll());
        return "form";  // Asegúrate de que esta ruta esté correcta
    }

    // Usamos @PostMapping para la actualización
    @PostMapping("/guardar")
    public String saveEmpleado(@ModelAttribute Empleado empleado, RedirectAttributes redirectAttrs) {
        if (empleado.getId() != null) {
            repository.save(empleado);
            redirectAttrs.addFlashAttribute("mensaje", "Empleado actualizado exitosamente");
        } else {
            repository.save(empleado);
            redirectAttrs.addFlashAttribute("mensaje", "Empleado guardado exitosamente");
        }
        return "redirect:/admin/empleados";
    }

    @GetMapping("/editar/{id}")
    public String showEditForm(@PathVariable String id, Model model) {
        Empleado empleado = repository.findById(id).orElse(null);
        if (empleado != null) {
            model.addAttribute("empleado", empleado);
            
            model.addAttribute("tiendas", Tiendarepository.findAll());
            return "editar-empleado";  // Asegúrate de que esta ruta esté correcta
        }
        return "redirect:/admin/empleados";  // Si el empleado no existe, redirige a la lista
    }

    @GetMapping("/eliminar/{id}")
    public String deleteEmpleado(@PathVariable String id, RedirectAttributes redirectAttrs) {
        Empleado empleado = repository.findById(id).orElse(null);
        if (empleado != null) {
            repository.deleteById(id);
            redirectAttrs.addFlashAttribute("mensaje", "Empleado eliminado exitosamente");
        } else {
            redirectAttrs.addFlashAttribute("mensaje", "Empleado no encontrado");
        }
        return "redirect:/admin/empleados";
    }
}
