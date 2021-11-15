package com.misiontic.facturacionapi.services;

import java.util.List;

import com.misiontic.facturacionapi.models.Producto;
import com.misiontic.facturacionapi.repositories.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    private ProductoRepository _productoRepository;

    @Autowired
    public ProductoService(ProductoRepository productoRepository){
        this._productoRepository = productoRepository;
    }
    public void save(Producto producto){
        this._productoRepository.save(producto);
    }

    public List<Producto>findAll(){
        return this._productoRepository.findAll();
    }
}
