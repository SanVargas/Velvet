package com.velvet.objetos;

import java.util.ArrayList;
import java.util.Date;

public class Usuario {
    private String nombre, correo, palabraSegura, celular, edad;
    private Interes intereses;
    private ArrayList<Match> lstMatch;

    public Usuario(String nombre, String correo, String celular, String clave, String edad) {
        this.lstMatch = new ArrayList<Match>();
        this.nombre = nombre;
        this.correo = correo;
        this.celular = celular;
        this.palabraSegura = clave;
        this.edad = edad;
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

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public Interes getIntereses() {
        return intereses;
    }

    public void setIntereses(Interes intereses) {
        this.intereses = intereses;
    }

    public ArrayList<Match> getLstMatch() {
        return lstMatch;
    }

    public void setLstMatch(ArrayList<Match> lstMatch) {
        this.lstMatch = lstMatch;
    }
}