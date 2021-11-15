package com.misiontic.facturacionapi.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Usuarios")
public class Usuario {
    private String id;
    private String documento;
    private String nombre;
    private String apellido;
    private String correo;
    private String telefono;
    private String username;
    private String password;

    public Usuario(String id,String documento,String nombre,String apellido,String correo,String telefono,String password,String username){
        this.id=id;
        this.documento=documento;
        this.nombre=nombre;
        this.apellido=apellido;
        this.correo=correo;
        this.telefono=telefono;
        this.password=password;
        this.username=username;
    }

    public Usuario(){

    }

     public void setId(String id) {
        this.id = id;
    }
    public void setDocumento(String documento) {
        this.documento = documento;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellido(String apellido) {
        this.apellido= apellido;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getId() {
        return id;
    }
    public String getDocumento() {
        return documento;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public String getTelefono() {
        return telefono;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
}

