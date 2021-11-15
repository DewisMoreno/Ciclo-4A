package com.misiontic.facturacionapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.misiontic.facturacionapi.models.Pedido;

import com.misiontic.facturacionapi.services.PedidoService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PedidoController {
    private PedidoService _pedidoService;

    @Autowired
    public PedidoController(PedidoService pedidoService) {
        this._pedidoService = pedidoService;
    }

    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/pedidos")
    public List<Pedido> findAll() {
        return this._pedidoService.findAll();
    }

    @PostMapping("/pedidos")
    public ResponseEntity<Map<String, String>> save(@RequestBody Pedido pedido) {
       
        this._pedidoService.save(pedido);
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "Se registró correctamente el pedido");
        return ResponseEntity.ok(response);
    }
}