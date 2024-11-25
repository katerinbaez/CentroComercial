package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.CComercial.app.repository.AdministradorRepository;
import com.CComercial.app.repository.TiendaRepository;
import com.CComercial.app.variables.Administrador;

@Controller
public class InicioController {

    @Autowired
    private AdministradorRepository administradorRepository;
    
    @Autowired
    private TiendaRepository tiendaRepository;  // Inyectamos TiendaRepository

    @GetMapping("/")
    public String inicio(Model model) {
        // Obtenemos todas las tiendas desde la base de datos
        model.addAttribute("tiendas", tiendaRepository.findAll());
        return "inicio";
    }

    @PostMapping("/add-admin")
    public String agregarAdmin(RedirectAttributes redirectAttributes) {
        if (administradorRepository.findAll().isEmpty()) {
            Administrador admin = new Administrador();
            admin.setUsuario("Admin");
            admin.setContraseña("Admin123");
            administradorRepository.save(admin);
            redirectAttributes.addFlashAttribute("mensaje", "Administrador predeterminado agregado.");
        } else {
            redirectAttributes.addFlashAttribute("mensaje", "Administrador ya existe.");
        }
        return "redirect:/";
    }

    @GetMapping("/login")
    public String seleccionUsuario() {
        return "seleccionUsuario";
    }
}
