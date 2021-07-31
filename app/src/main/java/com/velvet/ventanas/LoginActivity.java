package com.velvet.ventanas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.velvet.R;
import com.velvet.ventanas.RegistroActivity;

public class LoginActivity extends AppCompatActivity {

    private EditText txtUsuarioMain;
    private EditText txtClaveMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        txtUsuarioMain = (EditText)findViewById(R.id.txtUsuarioMain);
        txtClaveMain = (EditText)findViewById(R.id.txtClaveMain);
    }

    public void OnClickLogin(View v) {
    if (txtUsuarioMain.getText().toString().trim().equalsIgnoreCase("SV") && txtClaveMain.getText().toString().trim().equalsIgnoreCase("SV") ) {
            Intent r = new Intent(this, RegistroActivity.class);
            startActivity(r);
        } else {
            Toast.makeText(this, "Datos erroneos", Toast.LENGTH_LONG).show();
        }
    }

    public void OnClickRegistrarme(View v) {
        Intent i = new Intent(this, RegistroActivity.class);
        startActivity(i);
    }
}