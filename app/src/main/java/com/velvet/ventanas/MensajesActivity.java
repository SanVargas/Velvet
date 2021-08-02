package com.velvet.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.velvet.R;
import com.velvet.logica.Velvet;
import com.velvet.logica.citas.Match;
import com.velvet.logica.entidades.Usuario;

import java.util.ArrayList;

public class MensajesActivity extends AppCompatActivity {

    private TextView tMensajes;
    private ListView lstAmigos;

    private Usuario usuario;
    private Velvet vel;
    private ArrayList<Match> lstMatch;
    private String[] amigosNombres;
    private String[] amigosEdades;
    private String celularUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajes);

        lstMatch = new ArrayList<>();

        tMensajes = (TextView) findViewById(R.id.tMensajes);
        lstAmigos = (ListView) findViewById(R.id.lstAmigos);

        celularUsuario = getIntent().getStringExtra("usuario");

        amigosNombres = new String[lstMatch.size()];
        amigosEdades = new String[lstMatch.size()];

        for (int i = 0; i < amigosNombres.length; i++) {

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, amigosNombres);
        lstAmigos.setAdapter(adapter);
    }
}