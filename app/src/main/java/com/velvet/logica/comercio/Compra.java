package com.velvet.logica.comercio;


import com.velvet.logica.entidades.*;

import java.io.Serializable;

public class Compra implements Serializable {

    public final static String CREAR_TABLA_COMPRA ="CREATE TABLE COMPRA(id_compra TEXT, descripcion_compra TEXT, id_usuario TEXT, id_empresa TEXT)";

    private String id;
    private String descripcion;
    private Usuario usuario;
    private Empresa empresa;

    public Compra(String id, String descripcion, Usuario usuario, Empresa empresa) {
        this.id = id;
        this.descripcion = descripcion;
        this.usuario = usuario;
        this.empresa = empresa;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
