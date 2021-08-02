package com.velvet.logica;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.velvet.logica.DB.DataBase;
import com.velvet.logica.comercio.Anuncio;
import com.velvet.logica.entidades.Empresa;
import com.velvet.logica.entidades.Usuario;
import com.velvet.logica.entidades.atributos.Interes;

import java.io.Serializable;
import java.util.ArrayList;

public class Velvet implements Serializable {

    DataBase conection;
    private ArrayList<Anuncio> lstAnuncio;
    private ArrayList<Usuario> lstUsuario;
    private ArrayList<Empresa> lstEmpresa;

    public Velvet(Context con) {
        conection = new DataBase(con,"velvet", null, 1);
    }

    public void insertarUsuario(Usuario us)
    {
        SQLiteDatabase dbSQLITE = conection.getWritableDatabase();
        String sqlSenetenciaUsuario = "INSERT INTO USUARIO (nombre_usuario, telefono_usuario, edad_usuario, ciudad_usuario, id_orientacion, id_sexo,id_genero, correo, id_interes1,id_interes2,id_interes3)" +
                "VALUES ("+us.getNombre()+","+us.getTelefono()+","+us.getEdad()+","+us.getCiudad()+","+us.getOrientacion()+","+us.getSexo()+","+us.getGenero()+","+us.getCorreo()
                +","+us.getIntereses().getGeneroFavorito()+","+us.getIntereses().getLibroFavorito()+","+us.getIntereses().getPeliculaFavorita()+")";
        String sqlSenetenciaCre = "INSERT INTO CREDENCIAL (correo, clave) " +
                "VALUES ("+us.getCorreo()+","+us.getClave()+")";
        dbSQLITE.execSQL(sqlSenetenciaUsuario);
        dbSQLITE.execSQL(sqlSenetenciaCre);
        dbSQLITE.close();
        lstUsuario.add(us);
    }

    public boolean insertarEmpresa(Empresa em)
    {
        StringBuilder redes = new StringBuilder();
        for (String red: em.getLstRedes()) {
            redes.append(red).append(" - ");
        }

        SQLiteDatabase dbSQLITE = conection.getWritableDatabase();
        String sqlSenetenciaEmp = "INSERT INTO USUARIO (nit_empresa, nombre_empresa, categoria_empresa, redes_empresa, correo_empresa,clave_empresa)" +
                "VALUES ("+em.getNit()+","+em.getNombre()+","+em.getCategoria()+","+redes+","+em.getCorreo()+","+em.getClave()+")";

        String sqlSenetenciaCre = "INSERT INTO CREDENCIAL (correo, clave) " +
                "VALUES ("+em.getCorreo()+","+em.getClave()+")";
        dbSQLITE.execSQL(sqlSenetenciaEmp);
        dbSQLITE.execSQL(sqlSenetenciaCre);
        lstEmpresa.add(em);
        dbSQLITE.close();
        return true;
    }

    public boolean insertarLike(String id, Usuario u1, Usuario u2)
    {

        SQLiteDatabase dbSQLITE = conection.getWritableDatabase();
        String sqlSenetenciaLIKE = "INSERT INTO LIKES (id_like, id_usuario1, id_usuario2)" +
                "VALUES ("+id+","+u1.getCorreo()+","+u2.getCorreo()+")";
        dbSQLITE.execSQL(sqlSenetenciaLIKE);

        dbSQLITE.close();
        return true;
    }

    public boolean insertarMatch(String id, Usuario u1, Usuario u2)
    {
        SQLiteDatabase dbSQLITE = conection.getWritableDatabase();
        String sqlSenetenciaMATCH = "INSERT INTO MATCHES(id_match, id_usuario1, id_usuario2)" +
                "VALUES ("+id+","+u1.getCorreo()+","+u2.getCorreo()+")";
        dbSQLITE.execSQL(sqlSenetenciaMATCH);
        dbSQLITE.close();
        return true;
    }

    public boolean verificarCredencial(String correo, String clave)
    {
        boolean cen = false;

        try {
            SQLiteDatabase db = conection.getReadableDatabase();
            String[] parametros = {correo, clave};
            String sent = "SELECT * FROM CREDENCIAL WHERE correo = ? AND clave = ?";
            Cursor cursor = db.rawQuery(sent,parametros);

            while (cursor.moveToNext())
            {
                if(cursor.getString(0).equals(correo))
                {
                    cen = true;
                    break;
                }
            }

        }catch (Exception e)
        {
            cen = false;
        }
        return cen;
    }

    public boolean verificarExistenciaCorreo(String correo)
    {
        boolean cen = false;

        try {
            SQLiteDatabase db = conection.getReadableDatabase();
            String[] parametros = {correo};
            String sent = "SELECT * FROM CREDENCIAL WHERE correo = ?";
            Cursor cursor = db.rawQuery(sent,parametros);

            while (cursor.moveToNext())
            {
                if(cursor.getString(0).equals(correo))
                {
                    cen = true;
                    break;
                }
            }

        }catch (Exception e)
        {
            cen = false;
        }
        return cen;
    }

    public Usuario buscarUs(String celular)
    {
        Usuario us = new Usuario("","",0,"","","","","","");

        try {
            SQLiteDatabase db = conection.getReadableDatabase();
            String[] parametros = {celular};
            String sent = "SELECT * FROM USUARIO WHERE telefono_usuario = ?";
            Cursor cursor = db.rawQuery(sent,parametros);

            cursor.moveToFirst();
            us.setNombre(cursor.getString(0));
            us.setTelefono(cursor.getString(1));
            us.setEdad(cursor.getInt(2));
            us.setCiudad(cursor.getString(3));
            us.setOrientacion(cursor.getString(4));
            us.setSexo(cursor.getString(5));
            us.setGenero(cursor.getString(6));
            us.setCorreo(cursor.getString(7));

            Interes intereses = new Interes(cursor.getString(8),cursor.getString(9), cursor.getString(10));
            us.setIntereses(intereses);


        }catch (Exception e)
        {
            us = null;
        }
        return us;
    }

    public ArrayList<Anuncio> getLstAnuncio() {
        return lstAnuncio;
    }

    public void setLstAnuncio(ArrayList<Anuncio> lstAnuncio) {
        this.lstAnuncio = lstAnuncio;
    }

    public ArrayList<Usuario> getLstUsuario() {
        return lstUsuario;
    }

    public void setLstUsuario(ArrayList<Usuario> lstUsuario) {
        this.lstUsuario = lstUsuario;
    }

    public ArrayList<Empresa> getLstEmpresa() {
        return lstEmpresa;
    }

    public void setLstEmpresa(ArrayList<Empresa> lstEmpresa) {
        this.lstEmpresa = lstEmpresa;
    }
}
