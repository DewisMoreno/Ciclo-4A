package com.misiontic.facturacionapi.repositories;

import com.misiontic.facturacionapi.models.Pedido;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends MongoRepository<Pedido,String>{
    
}
