package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class AdminLoginController {

    @Autowired
    private AuthService authService;

    @GetMapping("/admin-login")
    public String loginAdmin() {
        return "adminLogin";
    }

    @PostMapping("/admin-login")
    public String autenticarAdmin(@RequestParam String usuario, @RequestParam String contraseña, Model model) {
        if (authService.authenticateAdmin(usuario, contraseña)) {
            return "redirect:/admin-dashboard";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "adminLogin";
        }
    }

    @GetMapping("/admin-dashboard")
    public String dashboardAdmin() {
        return "adminDashboard";
    }
}

