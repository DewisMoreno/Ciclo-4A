package com.misiontic.facturacionapi.repositories;

import com.misiontic.facturacionapi.models.Categoria;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends MongoRepository<Categoria,String> {   
}


