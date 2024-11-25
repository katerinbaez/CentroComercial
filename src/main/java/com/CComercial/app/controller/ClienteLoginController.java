package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ClienteLoginController {

    @Autowired
    private AuthService authService;

    @GetMapping("/cliente-login")
    public String loginCliente() {
        return "loginCliente";
    }


    @PostMapping("/cliente-login")
    public String autenticarCliente(@RequestParam String usuario, @RequestParam String contraseña, Model model) {
        if (authService.authenticateCliente(usuario, contraseña)) {
            return "redirect:/cliente-dashboard";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "clienteLogin";
        }
    }

    

    @GetMapping("/cliente-dashboard")
    public String dashboardCliente() {
        return "clienteDashboard";
    }
}
