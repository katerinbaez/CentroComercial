package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.Cliente;

public interface ClienteRepository extends MongoRepository<Cliente, String> {
    // Puedes agregar métodos personalizados de consulta aquí si es necesario
}
