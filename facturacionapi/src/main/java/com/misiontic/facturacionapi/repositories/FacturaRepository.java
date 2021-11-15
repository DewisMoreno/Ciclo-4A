package com.misiontic.facturacionapi.repositories;

import com.misiontic.facturacionapi.models.Factura;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepository extends MongoRepository<Factura,String>{
    
}
