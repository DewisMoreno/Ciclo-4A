package com.misiontic.facturacionapi.repositories;

import java.util.Optional;

import com.misiontic.facturacionapi.models.Usuario;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario,String> {
    public Optional<Usuario> findByUsername(String username);
}
