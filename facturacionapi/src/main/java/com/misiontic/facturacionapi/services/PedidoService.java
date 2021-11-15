package com.misiontic.facturacionapi.services;

import java.util.List;

import com.misiontic.facturacionapi.models.Pedido;
import com.misiontic.facturacionapi.repositories.PedidoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PedidoService {

    private PedidoRepository _pedidoRepository;

    @Autowired
    public PedidoService(PedidoRepository pedidoRepository){
        this._pedidoRepository = pedidoRepository;
    }
    public void save(Pedido pedido){
        this._pedidoRepository.save(pedido);
    }

    public List<Pedido>findAll(){
        return this._pedidoRepository.findAll();
    }
    
}
