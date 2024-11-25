package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.*;

public interface EstacionamientoRepository extends MongoRepository<Estacionamiento, String> {
    // Puedes agregar métodos personalizados si lo necesitas
}
