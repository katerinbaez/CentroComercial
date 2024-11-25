package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.CComercial.app.variables.Empleado;

import jakarta.servlet.http.HttpSession;

import org.springframework.ui.Model;

@Controller
public class EmpleadoLoginController {

    @Autowired
    private AuthService authService;

    @GetMapping("/empleado-login")
    public String loginEmpleado() {
        return "loginempleado"; 
    }

    @PostMapping("/empleado-login")
    public String autenticarEmpleado(
            @RequestParam String usuario,
            @RequestParam String contraseña,
            Model model,
            HttpSession session) {
        Empleado empleado = authService.authenticateEmpleado(usuario, contraseña);
        if (empleado != null) {
            session.setAttribute("empleado", empleado); // Guardar empleado en la sesión
            return "redirect:/dashboard-empleado";
        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "loginempleado";
        }
    }

    @GetMapping("/dashboard-empleado")
    public String dashboardEmpleado() {
        return "dashboardempleado"; 
    }
}
