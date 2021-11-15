package com.misiontic.facturacionapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.misiontic.facturacionapi.models.Factura;

import com.misiontic.facturacionapi.services.FacturaService;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class FacturaController {
    private FacturaService _facturaService;

    @Autowired
    public FacturaController(FacturaService facturaService) {
        this._facturaService = facturaService;
    }

    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/facturas")
    public List<Factura> findAll() {
        return this._facturaService.findAll();
    }

    @PostMapping("/facturas")
    public ResponseEntity<Map<String, String>> save(@RequestBody Factura factura) {
       
        this._facturaService.save(factura);
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "Se registró correctamente la factura");
        return ResponseEntity.ok(response);
    }
}