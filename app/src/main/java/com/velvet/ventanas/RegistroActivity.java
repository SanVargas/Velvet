package com.velvet.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.velvet.R;
import com.velvet.objetos.Usuario;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtNombre, txtCorreo, txtCelular, txtFechaNacimiento, txtClave;
    private TextView tNombre, tCorreo, tCelular, tFechaNacimiento, tClave;
    private String nombre, correo, celular, clave, fechaN;
    private Date fechaNacimiento;
    private Usuario usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        txtNombre = (EditText) findViewById(R.id.txtNombre);
        txtCorreo = (EditText) findViewById(R.id.txtCorreo);
        txtCelular = (EditText) findViewById(R.id.txtCelular);
        txtFechaNacimiento = (EditText) findViewById(R.id.txtFechaNacimiento);
        txtClave = (EditText) findViewById(R.id.txtClave);

        tNombre = (TextView) findViewById(R.id.tNombre);
        tCorreo = (TextView) findViewById(R.id.tCorreo);
        tCelular = (TextView) findViewById(R.id.tCelular);
        tFechaNacimiento = (TextView) findViewById(R.id.tFechaNacimiento);
        tClave = (TextView) findViewById(R.id.tClave);
    }

    public void onRegistrar(View v) {
        Toast.makeText(this, "Validando datos...", Toast.LENGTH_LONG).show();
        nombre = txtNombre.getText().toString();
        correo = txtCorreo.getText().toString();
        celular = txtCelular.getText().toString();
        fechaN = txtFechaNacimiento.getText().toString();
        clave = txtClave.getText().toString();
        System.out.println( "fecha "+fechaN);
        /**
         try {
         SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
         Date fecha = formato.parse(fechaN);
         fechaNacimiento = fecha;
         } catch (ParseException e) {
         e.printStackTrace();
         }
         */

        if (!nombre.equals("") && !correo.equals("") && !celular.equals("") && !fechaNacimiento.equals("") && !clave.equals("")) {
            usuario = new Usuario(nombre, correo, celular, clave, fechaNacimiento);
            Intent intent = new Intent(this, RegistroInteresesActivity.class);
            intent.putExtra("usuario", (Parcelable) usuario);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Complete todos los campos", Toast.LENGTH_LONG).show();
        }
    }
}