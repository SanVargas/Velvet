package com.velvet.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.velvet.R;
import com.velvet.objetos.Match;
import com.velvet.objetos.Usuario;
import com.velvet.objetos.Utilidad;

import java.util.ArrayList;

public class MensajesActivity extends AppCompatActivity {

    private TextView tMensajes;
    private ListView lstAmigos;

    private Usuario usuario;
    private Utilidad utilidad;
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
        usuario = utilidad.buscarUsuario(celularUsuario);

        lstMatch = usuario.getLstMatch();
        amigosNombres = new String[lstMatch.size()];
        amigosEdades = new String[lstMatch.size()];

        for (int i = 0; i < amigosNombres.length; i++) {
            amigosNombres[i] = lstMatch.get(i).getNombre();
            amigosEdades[i] = lstMatch.get(i).getEdad();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, amigosNombres);
        lstAmigos.setAdapter(adapter);
    }
}