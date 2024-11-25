package com.CComercial.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.CComercial.app.variables.Compra;
import com.CComercial.app.repository.CompraRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/compras")
public class CompraRestController {

    @Autowired
    private CompraRepository compraRepository;

    // Obtener todas las compras
    @GetMapping
    public List<Compra> getAllCompras() {
        return compraRepository.findAll();
    }

    // Obtener una compra por ID
    @GetMapping("/{id}")
    public ResponseEntity<Compra> getCompraById(@PathVariable String id) {
        Optional<Compra> compra = compraRepository.findById(id);
        return compra.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Crear una nueva compra
    @PostMapping
    public Compra createCompra(@RequestBody Compra compra) {
        return compraRepository.save(compra);
    }

    // Actualizar una compra existente
    @PutMapping("/{id}")
    public ResponseEntity<Compra> updateCompra(@PathVariable String id, @RequestBody Compra compraDetails) {
        Optional<Compra> compraOptional = compraRepository.findById(id);
        if (compraOptional.isPresent()) {
            Compra compra = compraOptional.get();
            compra.setNombre_Cliente(compraDetails.getNombre_Cliente());
            compra.setProducto(compraDetails.getProducto());
            compra.setCantidad(compraDetails.getCantidad());
            compra.setPrecio_unidad(compraDetails.getPrecio_unidad());
            compra.setTotal(compraDetails.getTotal());
            return ResponseEntity.ok(compraRepository.save(compra));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Eliminar una compra
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompra(@PathVariable String id) {
        if (compraRepository.existsById(id)) {
            compraRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
