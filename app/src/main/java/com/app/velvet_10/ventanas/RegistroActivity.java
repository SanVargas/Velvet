package com.app.velvet_10.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.velvet_10.R;

import java.security.spec.ECField;

public class RegistroActivity extends AppCompatActivity {
    private EditText txtNombre, txtCorreo, txtCelular, txtCedula, txtEdad, txtClave, txtCiudad, txtOrientacion, txtGeneroSexual, txtSexo;
    private TextView tNombre, tCorreo, tCelular, tEdad, tClave, tCedula, tGeneroSexual, tOrientacion, tSexo, tCiudad;

    private String nombre, correo, celular, clave, ciudad, orientacion, genero, sexo, codigo;
    private int edad;
    //private Velvet vel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_registro);
/**
 Bundle vell = getIntent().getExtras();
 if (vell != null) {
 vel = (Velvet) vell.getSerializable("vel");
 } else {
 vel = new Velvet(this);
 }

 Intent intent = new Intent(this, RegistroInteresesActivity.class);
 */

            txtNombre = (EditText) findViewById(R.id.txtNombre);
            txtCorreo = (EditText) findViewById(R.id.txtCorreo);
            txtCelular = (EditText) findViewById(R.id.txtCelular);
            txtEdad = (EditText) findViewById(R.id.txtEdad);
            txtClave = (EditText) findViewById(R.id.txtClave);
            txtCedula = (EditText) findViewById(R.id.txtCedula);
            txtGeneroSexual = (EditText) findViewById(R.id.txtGeneroSexual);
            txtOrientacion = (EditText) findViewById(R.id.txtOrientacion);
            txtCiudad = (EditText) findViewById(R.id.txtCiudad);
            txtSexo = (EditText) findViewById(R.id.txtSexo);

            tNombre = (TextView) findViewById(R.id.tNombre);
            tCorreo = (TextView) findViewById(R.id.tCorreo);
            tCelular = (TextView) findViewById(R.id.tCelular);
            tEdad = (TextView) findViewById(R.id.tEdad);
            tClave = (TextView) findViewById(R.id.tClave);
            tCedula = (TextView) findViewById(R.id.tCedula);
            tOrientacion = (TextView) findViewById(R.id.tOrientacion);
            tSexo = (TextView) findViewById(R.id.tSexo);
            tGeneroSexual = (TextView) findViewById(R.id.tGeneroSexual);
            tCiudad = (TextView) findViewById(R.id.tCiudad);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onClickRegistrarse(View view) {
        try {
            Toast.makeText(this, "Validando datos...", Toast.LENGTH_LONG).show();
            nombre = txtNombre.getText().toString();
            correo = txtCorreo.getText().toString();
            celular = txtCelular.getText().toString();
            ciudad = txtCiudad.getText().toString();
            orientacion = txtOrientacion.getText().toString();
            genero = txtGeneroSexual.getText().toString();
            sexo = txtSexo.getText().toString();
            edad = Integer.parseInt(txtEdad.getText().toString());
            clave = txtClave.getText().toString();
            codigo = txtCedula.getText().toString();

            if (!nombre.equals("") && !correo.equals("") && !celular.equals("") && edad != 0 && !clave.equals("")) {
                //  Usuario us = new Usuario(nombre, celular, edad, ciudad, orientacion, genero, sexo, correo, clave);
                Toast.makeText(this, "!BRUTAL!, SIGAMOS CON EL REGISTRO :)", Toast.LENGTH_LONG).show();

                 Intent intent = new Intent(this, RegistroInteresesActivity.class);
                //intent.putExtra("velvet", vel);
                // intent.putExtra("user", us);
                startActivity(intent);

            } else {
                Toast.makeText(this, "DATOS INCOMPLETOS", Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickCancelar(View view) {
        try {
            Intent intent = new Intent(this, IngresoActivity.class);
            startActivity(intent);
            finish();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}