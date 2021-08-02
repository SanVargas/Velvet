package com.velvet.logica.entidades;

import com.velvet.logica.comercio.Anuncio;
import com.velvet.logica.comercio.Compra;

import java.io.Serializable;
import java.util.ArrayList;

public class Empresa implements Serializable {

    public final static String CREAR_TABLA_EMPRESA = "CREATE TABLE EMPRESA(nit_empresa TEXT, nombre_empresa TEXT, categoria_empresa TEXT, redes_empresa TEXT, correo_empresa TEXT, clave_empresa TEXT)";


    private String nit;
    private String nombre;
    private String categoria;
    private String correo;
    private String clave;
    private ArrayList<String> lstRedes;
    private ArrayList<Anuncio> lstAnuncio;
    private ArrayList<Compra> lstCompra;

    public Empresa(String nit, String nombre, String categoria, String correo, String clave) {
        this.nit = nit;
        this.nombre = nombre;
        this.categoria = categoria;
        this.correo = correo;
        this.clave = clave;
        lstRedes= new ArrayList<>();
        lstAnuncio= new ArrayList<>();
        lstCompra= new ArrayList<>();
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public ArrayList<String> getLstRedes() {
        return lstRedes;
    }

    public void setLstRedes(ArrayList<String> lstRedes) {
        this.lstRedes = lstRedes;
    }

    public ArrayList<Anuncio> getLstAnuncio() {
        return lstAnuncio;
    }

    public void setLstAnuncio(ArrayList<Anuncio> lstAnuncio) {
        this.lstAnuncio = lstAnuncio;
    }

    public ArrayList<Compra> getLstCompra() {
        return lstCompra;
    }

    public void setLstCompra(ArrayList<Compra> lstCompra) {
        this.lstCompra = lstCompra;
    }
}
