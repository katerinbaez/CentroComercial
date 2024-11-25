package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.CComercial.app.variables.Historialdecompra;
import com.CComercial.app.repository.HistorialdecompraRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/historial")
public class HistorialRestController {

    @Autowired
    private HistorialdecompraRepository historialdecompraRepository;

    // Obtener todo el historial de compras
    @GetMapping
    public List<Historialdecompra> getAllHistorial() {
        return historialdecompraRepository.findAll();
    }

    // Obtener un historial por ID
    @GetMapping("/{id}")
    public ResponseEntity<Historialdecompra> getHistorialById(@PathVariable String id) {
        Optional<Historialdecompra> historial = historialdecompraRepository.findById(id);
        return historial.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo historial
    @PostMapping
    public Historialdecompra createHistorial(@RequestBody Historialdecompra historial) {
        return historialdecompraRepository.save(historial);
    }

    // Eliminar un historial
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHistorial(@PathVariable String id) {
        if (historialdecompraRepository.existsById(id)) {
            historialdecompraRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
