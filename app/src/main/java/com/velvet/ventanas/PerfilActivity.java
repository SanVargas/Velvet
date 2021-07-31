package com.velvet.ventanas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.velvet.R;
import com.velvet.objetos.Interes;
import com.velvet.objetos.Match;
import com.velvet.objetos.Usuario;
import com.velvet.objetos.Utilidad;

import java.util.ArrayList;

public class PerfilActivity extends AppCompatActivity {
    private TextView tMatch, tInstrucciones, tGeneroFavorito, tPeliculaFavorita, tLibroFavorito, tMostrarGenero, tMostartPelicula, tMostrarLibro;

    private Usuario usuario;
    private Match match;
    private Utilidad utilidad;
    private Interes interes;
    private String celularUsuario, nombreMatch, edadMatch;
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
        usuario = utilidad.buscarUsuario(celularUsuario);

        lstUsuarios = utilidad.getLstUsuarios();
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
        intent.putExtra("usuario", usuario.getCelular());
        startActivity(intent);
    }

    public void onMatch(View view) {
        Toast.makeText(this, "Estas en match", Toast.LENGTH_LONG).show();
    }

    public void onSiMatch(View view) {
        Toast.makeText(this, "Nuevo amigo", Toast.LENGTH_LONG).show();
        match = new Match(nombreMatch, edadMatch);
        usuario.getLstMatch().add(match);
        centinel = false;
        contador++;
    }

    public void onNoMatch(View view) {
        Toast.makeText(this, "Intenta con este", Toast.LENGTH_LONG).show();
        centinel = false;
        contador++;
    }

}