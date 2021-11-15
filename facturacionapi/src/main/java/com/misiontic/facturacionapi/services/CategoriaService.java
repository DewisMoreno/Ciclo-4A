package com.misiontic.facturacionapi.services;

import java.util.List;
import java.util.Optional;

import com.misiontic.facturacionapi.models.Categoria;
import com.misiontic.facturacionapi.repositories.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private CategoriaRepository _categoriaRepository;

    @Autowired
    public CategoriaService(CategoriaRepository categoriaRepository){
        this._categoriaRepository = categoriaRepository;
    }

    public void save(Categoria categoria){
        this._categoriaRepository.save(categoria);
    }

    public List<Categoria>findAll(){
        return this._categoriaRepository.findAll();
    }

    public Optional<Categoria>findById(String id){
        return this._categoriaRepository.findById(id);
    }

    public void deleteById(String id){
        this._categoriaRepository.deleteById(id);
    }

    public Boolean existById(String id){
        return this._categoriaRepository.existsById(id);
    }

}

