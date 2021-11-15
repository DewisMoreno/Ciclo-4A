package com.misiontic.facturacionapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.misiontic.facturacionapi.models.Producto;
import com.misiontic.facturacionapi.services.ProductoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ProductoController {
    private ProductoService _productoService;

    @Autowired
    public ProductoController(ProductoService productoService) {
        this._productoService = productoService;
    }

    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/productos")
    public List<Producto> findAll() {
        return this._productoService.findAll();
    }

    @PostMapping("/productos")
    public ResponseEntity<Map<String, String>> save(@RequestBody Producto producto) {
       
        this._productoService.save(producto);
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "Se registró correctamente el producto");
        return ResponseEntity.ok(response);
    }
}