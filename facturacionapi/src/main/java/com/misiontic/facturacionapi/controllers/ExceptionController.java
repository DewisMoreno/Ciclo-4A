package com.misiontic.facturacionapi.controllers;

import com.misiontic.facturacionapi.exception.CustomException;
import com.misiontic.facturacionapi.exception.Mensaje;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(CustomException.class)
    public Mensaje ErrorException(CustomException exception){
        return new Mensaje("CustomExeption",exception.getMessage());
    }
}
