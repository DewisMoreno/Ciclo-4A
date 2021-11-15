package com.misiontic.facturacionapi.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import com.misiontic.facturacionapi.exception.CustomException;
import com.misiontic.facturacionapi.models.Categoria;
import com.misiontic.facturacionapi.services.CategoriaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@RequestMapping("/api/v1")
public class CategoriaController {
    private CategoriaService _categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this._categoriaService = categoriaService;
    }

    // @RequestMapping(method=RequestMethod.GET)
    @GetMapping("/categorias")
    public List<Categoria> findAll() {
        return this._categoriaService.findAll();
    }

    @PostMapping("/categorias")
    public ResponseEntity<Map<String, String>> save(@RequestBody @Valid Categoria categoria, Errors errors) {
        if(errors.hasErrors()){
            throwError(errors);
        }
        this._categoriaService.save(categoria);
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "Se registró correctamente la categoria");
        return ResponseEntity.ok(response);
    }

    @PutMapping("/categorias")
    public ResponseEntity<Map<String, String>> update(@RequestBody Categoria categoria) {
        this._categoriaService.save(categoria);
        Map<String, String> response = new HashMap<>();
        response.put("Mensaje", "La categoria se actualizó correctamente");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/categorias/{id}")
    public ResponseEntity<Map<String, String>> delete(@PathVariable String id) {

        Boolean existeCategoria = this._categoriaService.existById(id);
        Map<String, String> response = new HashMap<>();
        this._categoriaService.deleteById(id);
        

        if (!existeCategoria) {
            response.put("Mensaje", "La categoria no existe en la base de datos");
            return ResponseEntity.ok(response);

        }
        this._categoriaService.deleteById(id);
        response.put("Mensaje", "La categoria se ha eliminado correctamente");
        return ResponseEntity.ok(response);
    }

    //Este metodo se encarga de mostrar el error
    public void  throwError(Errors errors){
        String mensaje = "";
        int index = 0;
        for(ObjectError e:errors.getAllErrors()){
            if(index>0){
                mensaje+=" | ";
            }
            System.out.println(""+e.getDefaultMessage());
            mensaje+=String.format("Parametro: %s - Mensaje: %s", e.getObjectName(),e.getDefaultMessage());
        }
        throw new CustomException(mensaje);
    }

}
