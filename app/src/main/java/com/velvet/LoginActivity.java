package com.velvet;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.net.PasswordAuthentication;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsuarioMain;
    private EditText txtClaveMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuarioMain = findViewById(R.id.txtUsuarioMain);
        txtClaveMain = findViewById(R.id.txtClaveMain);
    }

    public void OnClickLogin (View v){
        if (txtUsuarioMain.getText().toString().trim()!=""&&txtClaveMain.getText().toString().trim()!=""){
            Toast.makeText(this,"Validando...", Toast.LENGTH_LONG).show();
        } else
            Toast.makeText(this,"Ingrese los datos!", Toast.LENGTH_LONG).show();
    }

    public void OnClickRegistrarme (View v){
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
}