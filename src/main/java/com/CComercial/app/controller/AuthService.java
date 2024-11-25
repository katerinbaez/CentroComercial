package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.CComercial.app.repository.*;
import com.CComercial.app.variables.Empleado;

@Service
public class AuthService {

    @Autowired
    private AdministradorRepository administradorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    public boolean authenticateAdmin(String usuario, String contraseña) {
        return administradorRepository.findAll().stream()
                .anyMatch(admin -> admin.getUsuario().equals(usuario) && admin.getContraseña().equals(contraseña));
    }

    public boolean authenticateCliente(String usuario, String contraseña) {
        return clienteRepository.findAll().stream()
                .anyMatch(cliente -> cliente.getUsuario().equals(usuario) && cliente.getContraseña().equals(contraseña));
    }

    public Empleado authenticateEmpleado(String usuario, String contraseña) {
        return empleadoRepository.findAll().stream()
                .filter(empleado -> empleado.getUsuario().equals(usuario) && empleado.getContraseña().equals(contraseña))
                .findFirst()
                .orElse(null);
    }

}
