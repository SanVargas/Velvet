package com.velvet.logica.entidades.atributos;

import java.io.Serializable;

public class Interes implements Serializable {

    private String peliculaFavorita;
    private String libroFavorito;
    private String generoFavorito;

    public Interes(String peliculaFavorita, String libroFavorito, String generoFavorito) {
        this.peliculaFavorita = peliculaFavorita;
        this.libroFavorito = libroFavorito;
        this.generoFavorito = generoFavorito;
    }

    public String getPeliculaFavorita() {
        return peliculaFavorita;
    }

    public void setPeliculaFavorita(String peliculaFavorita) {
        this.peliculaFavorita = peliculaFavorita;
    }

    public String getLibroFavorito() {
        return libroFavorito;
    }

    public void setLibroFavorito(String libroFavorito) {
        this.libroFavorito = libroFavorito;
    }

    public String getGeneroFavorito() {
        return generoFavorito;
    }

    public void setGeneroFavorito(String generoFavorito) {
        this.generoFavorito = generoFavorito;
    }
}
