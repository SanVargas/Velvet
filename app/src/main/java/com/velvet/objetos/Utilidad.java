package com.velvet.objetos;

import java.util.ArrayList;
import java.util.List;

public class Utilidad {
    Usuario usuario;
    ArrayList<Usuario> lstUsuarios = new ArrayList<Usuario>();

    public Usuario buscarUsuario(String celular) {
        for (Usuario us : lstUsuarios) {
            if (us.getCelular().equals(celular)) {
                usuario = us;
                break;
            }
        }
        return usuario;
    }

    public void guardarUsuario(Usuario usuario) {
        lstUsuarios.add(usuario);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public ArrayList<Usuario> getLstUsuarios() {
        return lstUsuarios;
    }

    public void setLstUsuarios(ArrayList<Usuario> lstUsuarios) {
        this.lstUsuarios = lstUsuarios;
    }
}
