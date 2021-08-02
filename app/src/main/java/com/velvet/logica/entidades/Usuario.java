package com.velvet.logica.entidades;

import com.velvet.logica.comercio.Compra;
import com.velvet.logica.entidades.atributos.Genero;
import com.velvet.logica.entidades.atributos.Interes;
import com.velvet.logica.entidades.atributos.Orientacion;
import com.velvet.logica.entidades.atributos.Sexo;

import java.io.Serializable;
import java.util.ArrayList;

public class Usuario implements Serializable {

    public final static String CREAR_TABLA_USUARIO = "CREATE TABLE USUARIO(nombre_usuario TEXT, telefono_usuario TEXT, edad_usuario INTEGER, ciudad_usuario TEXT, " +
            "id_orientacion TEXT, id_sexo TEXT,id_genero TEXT, correo TEXT, id_interes1 TEXT,id_interes2 TEXT,id_interes3 TEXT)";

    private String nombre;
    private String telefono;
    private int edad;
    private String ciudad;
    private String orientacion;
    private String genero;
    private String sexo;
    private String correo;
    private String clave;
    private Interes intereses;
    private ArrayList<Usuario> lstLikes;
    private ArrayList<Usuario> lstMaches;
    private ArrayList<Compra> lstCompra;

    public Usuario(String nombre, String telefono, int edad, String ciudad, String orientacion, String genero, String sexo, String correo, String clave) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.edad = edad;
        this.ciudad = ciudad;
        this.orientacion = orientacion;
        this.genero = genero;
        this.sexo = sexo;
        this.correo = correo;
        this.clave = clave;
        intereses = new Interes("","","");

        lstCompra = new ArrayList<>();
        lstLikes= new ArrayList<>();
        lstMaches = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getOrientacion() {
        return orientacion;
    }

    public void setOrientacion(String orientacion) {
        this.orientacion = orientacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
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

    public Interes getIntereses() {
        return intereses;
    }

    public void setIntereses(Interes intereses) {
        this.intereses = intereses;
    }

    public ArrayList<Usuario> getLstLikes() {
        return lstLikes;
    }

    public void setLstLikes(ArrayList<Usuario> lstLikes) {
        this.lstLikes = lstLikes;
    }

    public ArrayList<Usuario> getLstMaches() {
        return lstMaches;
    }

    public void setLstMaches(ArrayList<Usuario> lstMaches) {
        this.lstMaches = lstMaches;
    }

    public ArrayList<Compra> getLstCompra() {
        return lstCompra;
    }

    public void setLstCompra(ArrayList<Compra> lstCompra) {
        this.lstCompra = lstCompra;
    }
}
