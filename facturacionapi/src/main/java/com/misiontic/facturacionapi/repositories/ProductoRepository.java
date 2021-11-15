package com.misiontic.facturacionapi.repositories;

import com.misiontic.facturacionapi.models.Producto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends MongoRepository<Producto,String> {
   
}

