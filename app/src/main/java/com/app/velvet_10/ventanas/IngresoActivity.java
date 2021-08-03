package com.app.velvet_10.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.app.velvet_10.R;

public class IngresoActivity extends AppCompatActivity {
    private EditText txtUsuarioIngreso, txtClaveIngreso;
    private TextView tUsuarioIngreso, tClaveIngreso;
    //private Velvet velvet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);
        try {
            txtUsuarioIngreso = (EditText) findViewById(R.id.txtUsuarioIngreso);
            txtClaveIngreso = (EditText) findViewById(R.id.txtClaveIngreso);

            tUsuarioIngreso = (TextView) findViewById(R.id.tIngresoUsuario);
            tClaveIngreso = (TextView) findViewById(R.id.tClaveIngreso);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void onClickIngresar(View view) {
        try {
            //vel = new Velvet(this);
            String correo = txtUsuarioIngreso.getText().toString().trim();
            String clave = txtClaveIngreso.getText().toString().trim();

            Toast.makeText(this, correo + " - " + clave, Toast.LENGTH_LONG).show();

            if (correo.equals("prueba") && clave.equals("1234")) {
                Intent r = new Intent(this, PerfilActivity.class);
                startActivity(r);
            } else {
                /**
                 if(vel.verificarExistenciaCorreo(correo))
                 {
                 if (vel.verificarCredencial(correo, clave)) {
                 Intent r = new Intent(this, RegistroActivity.class);
                 Bundle b = new Bundle();
                 b.putSerializable("velvet", vel);
                 r.putExtras(b);
                 startActivity(r);
                 } else {
                 Toast.makeText(this, "CORREO/CLAVE INCORRECTA, VERIFIQUE", Toast.LENGTH_LONG).show();
                 }
                 }else
                 {
                 Toast.makeText(this, "CORREO NO ENCONTRADO, POR FAVOR REGISTRESE", Toast.LENGTH_LONG).show();
                 }
                 */
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onClickRegistrar(View view) {
        try {
            Intent i = new Intent(this, RegistroActivity.class);
            startActivity(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}