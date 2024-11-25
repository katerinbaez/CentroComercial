package com.CComercial.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.CComercial.app.variables.*;

public interface ProductosRepository extends MongoRepository<Productos, String> {

}
