package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.Compra;

public interface CompraRepository extends MongoRepository<Compra, String> {
    // Métodos personalizados, si es necesario
}
