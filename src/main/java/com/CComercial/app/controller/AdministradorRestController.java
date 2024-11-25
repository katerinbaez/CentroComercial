package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.CComercial.app.repository.*;
import com.CComercial.app.variables.*;
import java.util.List;

@RestController
@RequestMapping("/api/administradores")
public class AdministradorRestController {

    @Autowired
    private AdministradorRepository repository;

    @GetMapping
    public List<Administrador> getAllAdministradores() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Administrador getAdministradorById(@PathVariable String id) {
        return repository.findById(id).orElse(null);
    }

    @PostMapping
    public Administrador createAdministrador(@RequestBody Administrador administrador) {
        return repository.save(administrador);
    }

    @PutMapping("/{id}")
    public Administrador updateAdministrador(@PathVariable String id, @RequestBody Administrador administrador) {
        administrador.setId(id);
        return repository.save(administrador);
    }

    @DeleteMapping("/{id}")
    public void deleteAdministrador(@PathVariable String id) {
        repository.deleteById(id);
    }
}
