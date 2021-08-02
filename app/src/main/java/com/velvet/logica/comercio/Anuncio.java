package com.velvet.logica.comercio;

import com.velvet.logica.entidades.Empresa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Anuncio implements Serializable {
    public final static String CREAR_TABLA_ANUNCIO = "CREATE TABLE ANUNCIO(id_anuncio TEXT, tipo_anuncio TEXT, nombre_anuncio TEXT, descripcion_anuncio TEXT, fechaIn_anuncio TEXT, fechaFin_anuncio TEXT, imagenes_anuncio TEXT, precio_anuncio REAL, nit_empresa TEXT)";
    private String id;
    private String nombre;
    private String descripcion;
    private String tipo;
    private ArrayList<String> lstImagenes;
    private Date fechaInicio;
    private Date fechaFinal;
    private double precio;
    private Empresa empresa;

    public Anuncio(String id, String nombre, String descripcion, String tipo, Date fechaInicio, Date fechaFinal, double precio, Empresa empresa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.tipo = tipo;
        this.fechaInicio = fechaInicio;
        this.fechaFinal = fechaFinal;
        this.precio = precio;
        this.empresa = empresa;
        lstImagenes = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<String> getLstImagenes() {
        return lstImagenes;
    }

    public void setLstImagenes(ArrayList<String> lstImagenes) {
        this.lstImagenes = lstImagenes;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
