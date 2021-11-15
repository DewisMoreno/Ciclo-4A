package com.misiontic.facturacionapi.services;

import java.util.List;

import com.misiontic.facturacionapi.models.Factura;

import com.misiontic.facturacionapi.repositories.FacturaRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacturaService {

    private FacturaRepository _facturaRepository;

    @Autowired
    public FacturaService(FacturaRepository facturaRepository){
        this._facturaRepository = facturaRepository;
    }
    public void save(Factura factura){
        this._facturaRepository.save(factura);
    }

    public List<Factura>findAll(){
        return this._facturaRepository.findAll();
    }
    
}
