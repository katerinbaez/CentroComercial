package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.CComercial.app.variables.Compra;
import com.CComercial.app.repository.CompraRepository;

@Controller
@RequestMapping("/compras")
public class CompraWebController {

    @Autowired
    private CompraRepository compraRepository;

    // Mostrar todas las compras
    @GetMapping
    public String listCompras(Model model) {
        model.addAttribute("compras", compraRepository.findAll());
        return "listacompras"; // Vista Thymeleaf
    }

    // Mostrar formulario para agregar nueva compra
    @GetMapping("/nuevo")
    public String showNewCompraForm(Model model) {
        model.addAttribute("compra", new Compra());
        return "nuevacompra"; // Vista Thymeleaf
    }

    // Guardar nueva compra
    @PostMapping
    public String saveCompra(@ModelAttribute Compra compra) {
        compraRepository.save(compra);
        return "redirect:/compras";
    }

    // Mostrar formulario para editar compra
    @GetMapping("/editar/{id}")
    public String showEditCompraForm(@PathVariable String id, Model model) {
        Compra compra = compraRepository.findById(id).orElse(null);
        model.addAttribute("compra", compra);
        return "editarcompra"; // Vista Thymeleaf
    }

    // Actualizar compra existente
    @PostMapping("/editar/{id}")
    public String updateCompra(@PathVariable String id, @ModelAttribute Compra compra) {
        compra.setId(id);
        compraRepository.save(compra);
        return "redirect:/compras";
    }

    // Eliminar compra
    @GetMapping("/eliminar/{id}")
    public String deleteCompra(@PathVariable String id) {
        compraRepository.deleteById(id);
        return "redirect:/compras";
    }
}
