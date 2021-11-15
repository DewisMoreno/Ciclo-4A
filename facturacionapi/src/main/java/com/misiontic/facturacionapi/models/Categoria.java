package com.misiontic.facturacionapi.models;

import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Categorias")
public class Categoria {


    @Id
    private String id;
    @NotEmpty(message = "El campo no puede estar vacío")
    private String nombre;
    private String descripcion;
    
    
    public Categoria() {

    }

  public void setId(String id){
      this.id = id;
  }

  public void setNombre(String nombre){
      this.nombre = nombre;
  }

  public void setDescripcion (String descripcion){
      this.descripcion = descripcion;
  }

  public String getId(){
      return id;
  }

  public String getNombre(){
      return nombre;
  }

  public String getDescripcion(){
      return descripcion;
  }

    
}
