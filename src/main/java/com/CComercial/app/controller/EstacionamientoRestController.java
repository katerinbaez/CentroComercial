package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.CComercial.app.variables.Estacionamiento;
import com.CComercial.app.repository.EstacionamientoRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estacionamientos")
public class EstacionamientoRestController {

    @Autowired
    private EstacionamientoRepository estacionamientoRepository;

    // Obtener todos los estacionamientos
    @GetMapping
    public List<Estacionamiento> getAllEstacionamientos() {
        return estacionamientoRepository.findAll();
    }

    // Obtener un estacionamiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Estacionamiento> getEstacionamientoById(@PathVariable String id) {
        Optional<Estacionamiento> estacionamiento = estacionamientoRepository.findById(id);
        return estacionamiento.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo estacionamiento
    @PostMapping
    public Estacionamiento createEstacionamiento(@RequestBody Estacionamiento estacionamiento) {
        return estacionamientoRepository.save(estacionamiento);
    }

    // Actualizar un estacionamiento existente
    @PutMapping("/{id}")
    public ResponseEntity<Estacionamiento> updateEstacionamiento(
            @PathVariable String id,
            @RequestBody Estacionamiento estacionamientoDetails) {
        Optional<Estacionamiento> estacionamientoOptional = estacionamientoRepository.findById(id);
        if (estacionamientoOptional.isPresent()) {
            Estacionamiento estacionamiento = estacionamientoOptional.get();
            estacionamiento.setNumero(estacionamientoDetails.getNumero());
            estacionamiento.setEstado(estacionamientoDetails.getEstado());
            return ResponseEntity.ok(estacionamientoRepository.save(estacionamiento));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar un estacionamiento
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEstacionamiento(@PathVariable String id) {
        if (estacionamientoRepository.existsById(id)) {
            estacionamientoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
