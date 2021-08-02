package com.velvet.ventanas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.velvet.R;
import com.velvet.logica.Velvet;
import com.velvet.ventanas.RegistroActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsuarioMain;
    private EditText txtClaveMain;
    private Velvet vel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuarioMain = (EditText)findViewById(R.id.txtUsuarioMain);
        txtClaveMain = (EditText)findViewById(R.id.txtClaveMain);
    }

    public void OnClickLogin(View v) {
        vel = new Velvet(this);
        String correo = txtUsuarioMain.getText().toString().trim();
        String clave = txtClaveMain.getText().toString().trim();

        Toast.makeText(this, correo + " - "+clave, Toast.LENGTH_LONG).show();

        if(correo.equals("prueba")&&clave.equals("1234"))
        {
            try {
                Intent r = new Intent(this, PerfilActivity.class);
                startActivity(r);
            }catch (Exception e)
            {
                Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
            }

        }else{
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
        }

    }

    public void OnClickRegistrarme(View v) {
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
}