package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.Empleado;

public interface EmpleadoRepository extends MongoRepository<Empleado, String> {
}
