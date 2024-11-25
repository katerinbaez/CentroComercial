package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.*;

public interface TiendaRepository extends MongoRepository<Tienda, String> {
}
