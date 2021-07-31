package com.velvet.objetos;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String nombre, correo, palabraSegura, celular;
    private Date fechaNacimiento;
    private ArrayList<Interes> lstIntereses;

    public Usuario(String nombre, String correo, String celular, String clave, Date fechaNacimiento) {
        this.lstIntereses = new ArrayList<Interes>();
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.palabraSegura = clave;
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPalabraSegura() {
        return palabraSegura;
    }

    public void setPalabraSegura(String palabraSegura) {
        this.palabraSegura = palabraSegura;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public ArrayList<Interes> getLstIntereses() {
        return lstIntereses;
    }

    public void setLstIntereses(ArrayList<Interes> lstIntereses) {
        this.lstIntereses = lstIntereses;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}