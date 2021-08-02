package com.velvet.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.velvet.R;
import com.velvet.logica.Velvet;
import com.velvet.logica.citas.Match;
import com.velvet.logica.entidades.Usuario;
import com.velvet.logica.entidades.atributos.Interes;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {
    private TextView tMatch, tInstrucciones, tGeneroFavorito, tPeliculaFavorita, tLibroFavorito, tMostrarGenero, tMostartPelicula, tMostrarLibro;

    private Usuario usuario;
    private Match match;
    private Velvet velvet;
    private Interes interes;
    private int edadMatch;
    private String nombreMatch,celularUsuario;
    private ArrayList<Usuario> lstUsuarios;
    private boolean centinel = true;
    private boolean hilo;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        lstUsuarios = new ArrayList<>();

        tMatch = (TextView) findViewById(R.id.tMatch);
        tInstrucciones = (TextView) findViewById(R.id.tInstrucciones);
        tGeneroFavorito = (TextView) findViewById(R.id.tGeneroFavortio);
        tPeliculaFavorita = (TextView) findViewById(R.id.tPeliculaFavorita);
        tLibroFavorito = (TextView) findViewById(R.id.tLibroFavorito);
        tMostrarGenero = (TextView) findViewById(R.id.tMostarGenero);
        tMostartPelicula = (TextView) findViewById(R.id.tMostarPelicula);
        tMostrarLibro = (TextView) findViewById(R.id.tMostrarLibro);

        celularUsuario = getIntent().getStringExtra("usuario");
        usuario = velvet.buscarUs(celularUsuario);

        lstUsuarios = velvet.getLstUsuario();
        for (Usuario usuarioMatch : lstUsuarios) {
            nombreMatch = usuarioMatch.getNombre();
            edadMatch = usuarioMatch.getEdad();
            interes = usuarioMatch.getIntereses();

            tGeneroFavorito.setText(interes.getGeneroFavorito());
            tPeliculaFavorita.setText(interes.getPeliculaFavorita());
            tLibroFavorito.setText(interes.getLibroFavorito());

            hilo = true;
            while (hilo) {
                if (!centinel && contador <= lstUsuarios.size()) ;
                hilo = false;
            }
        }
    }

    public void onPerfil(View view) {
        Toast.makeText(this, "Estamos en mantenimiento", Toast.LENGTH_LONG).show();
    }

    public void onMensaje(View view) {
        Intent intent = new Intent(this, MensajesActivity.class);
        intent.putExtra("usuario", usuario);
        startActivity(intent);
    }

    public void onMatch(View view) {
        Toast.makeText(this, "Estas en match", Toast.LENGTH_LONG).show();
    }

    public void onSiMatch(View view) {
        Toast.makeText(this, "Nuevo amigo", Toast.LENGTH_LONG).show();
        centinel = false;
        contador++;
    }

    public void onNoMatch(View view) {
        Toast.makeText(this, "Intenta con este", Toast.LENGTH_LONG).show();
        centinel = false;
        contador++;
    }

}