package com.misiontic.facturacionapi.models;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;


@Document(collection = "Facturas")
public class Factura {

    @Id
    private String id;
    private Usuario cliente;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    //@JsonFormat(pattern = "yyyy-MM-dd")
    private Date fecha;
    
    private Pedido pedido;
    private String lugarEntrega;
    private String modoPago;

    public Factura() {
    }

    public Factura(String id, Usuario cliente, Date fecha, Pedido pedido, String lugarEntrega, String modoPago) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.pedido = pedido;
        this.lugarEntrega = lugarEntrega;
        this.modoPago = modoPago;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Usuario getCliente() {
        return cliente;
    }

    public void setCliente(Usuario cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public String getLugarEntrega() {
        return lugarEntrega;
    }

    public void setLugarEntrega(String lugarEntrega) {
        this.lugarEntrega = lugarEntrega;
    }

    public String getModoPago() {
        return modoPago;
    }

    public void setModoPago(String modoPago) {
        this.modoPago = modoPago;
    }
 
}
