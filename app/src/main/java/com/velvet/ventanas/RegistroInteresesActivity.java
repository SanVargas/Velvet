package com.velvet.ventanas;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.velvet.R;
import com.velvet.logica.Velvet;
import com.velvet.logica.entidades.Usuario;
import com.velvet.logica.entidades.atributos.Interes;

import java.util.List;


public class RegistroInteresesActivity extends AppCompatActivity {
    private TextView tTituloInteres, tGenero, tP1, tP2, tP3;
    private Spinner spinnerP1, spinnerP2, spinnerP3;

    private String opcionesP1[] = new String[3];
    private String opcionesP2[] = new String[3];
    private String opcionesP3[] = new String[3];

    private Usuario us;
    private Velvet velvet;
    private String peliculaFavorita, libroFavorito, generoFavorito, celularUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_intereses);

        Bundle vell = getIntent().getExtras();
        if(vell!=null)
        {
            velvet = (Velvet) vell.getSerializable("velvet");
            us = (Usuario) vell.getSerializable("user");
        }else
        {
            velvet = new Velvet(this);
        }

        spinnerP1 = (Spinner) findViewById(R.id.spinnerP1);
        spinnerP2 = (Spinner) findViewById(R.id.spinnerP2);
        spinnerP3 = (Spinner) findViewById(R.id.spinnerP3);

        tTituloInteres = (TextView) findViewById(R.id.txtTituloIntereses);
        tGenero = (TextView) findViewById(R.id.txtGenero);
        tP1 = (TextView) findViewById(R.id.txtP1);
        tP2 = (TextView) findViewById(R.id.txtP2);
        tP3 = (TextView) findViewById(R.id.txtP3);

        opcionesP1 = new String[]{"Terror", "Accion", "Ciencia Ficcion", "Romantico"};
        ArrayAdapter<String> adapterP1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesP1);
        spinnerP1.setAdapter(adapterP1);
        generoFavorito = spinnerP1.getSelectedItem().toString();

        opcionesP2 = new String[]{"Harry Potter", "Los vengadores", "Crepusculo", "Actividad paranormal"};
        ArrayAdapter<String> adapterP2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesP2);
        spinnerP2.setAdapter(adapterP2);
        peliculaFavorita = spinnerP2.getSelectedItem().toString();

        opcionesP3 = new String[]{"50 Sombras de Gray", "Laland", "Foctotum", "Señor de los anillos"};
        ArrayAdapter<String> adapterP3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesP3);
        spinnerP3.setAdapter(adapterP3);
        libroFavorito = spinnerP3.getSelectedItem().toString();


    }

    public void onSiguiente(View view) {
        Toast.makeText(this, "Registrado con exito", Toast.LENGTH_LONG).show();
        Interes interes = new Interes(peliculaFavorita, libroFavorito, generoFavorito);
        us.setIntereses(interes);
        velvet.insertarUsuario(us);
        Intent intent = new Intent(this, PerfilActivity.class);
        Bundle b = new Bundle();
        b.putSerializable("velvet", velvet);
        b.putSerializable("usuario", us);
        intent.putExtras(b);
        startActivity(intent);
    }

}