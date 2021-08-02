package com.velvet.logica.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.velvet.logica.comercio.Anuncio;
import com.velvet.logica.comercio.Compra;
import com.velvet.logica.entidades.Empresa;
import com.velvet.logica.entidades.Usuario;

import java.io.Serializable;

public class DataBase extends SQLiteOpenHelper implements Serializable {

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE CREDENCIAL(correo TEXT, clave TEXT)");
        db.execSQL("CREATE TABLE LIKES(id_like TEXT, id_usuario1 TEXT, id_usuario2 TEXT)");
        db.execSQL("CREATE TABLE MATCHES(id_match TEXT, id_usuario1 TEXT, id_usuario2 TEXT)");
        db.execSQL(Empresa.CREAR_TABLA_EMPRESA);
        db.execSQL(Anuncio.CREAR_TABLA_ANUNCIO);
        db.execSQL(Compra.CREAR_TABLA_COMPRA);
        db.execSQL(Usuario.CREAR_TABLA_USUARIO);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAntigua, int versionNueva) {

        db.execSQL("DROP TABLE IF EXISTS CREDENCIAL");
        db.execSQL("DROP TABLE IF EXISTS LIKES");
        db.execSQL("DROP TABLE IF EXISTS EMPRESA");
        db.execSQL("DROP TABLE IF EXISTS ANUNCIO");
        db.execSQL("DROP TABLE IF EXISTS COMPRA");
        db.execSQL("DROP TABLE IF EXISTS USUARIO");
        onCreate(db);
    }


}
