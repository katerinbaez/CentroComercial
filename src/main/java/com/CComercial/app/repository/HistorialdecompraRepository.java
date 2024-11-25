package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.Historialdecompra;

public interface HistorialdecompraRepository extends MongoRepository<Historialdecompra, String> {
    // Métodos personalizados, si es necesario
}
