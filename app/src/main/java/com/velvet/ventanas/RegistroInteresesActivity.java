package com.velvet.ventanas;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.velvet.R;

import java.util.List;


public class RegistroInteresesActivity extends AppCompatActivity {
    private TextView txtTituloInteres, txtGenero, txtP1, txtP2, txtP3;
    private Spinner spinnerP1, spinnerP2, spinnerP3;
    private Button btnSiguiente;
    private String peliculaFavorita, libroFavorito, generoFavorito, hobbieFavorito, musicaFavorita, planFavorito;
    private String opcionesP1[] = new String[3];
    private String opcionesP2[] = new String[3];
    private String opcionesP3[] = new String[3];
    private int paginar = 1;
    private boolean centinela = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_intereses);

        spinnerP1 = (Spinner) findViewById(R.id.spinnerP1);
        spinnerP2 = (Spinner) findViewById(R.id.spinnerP2);
        spinnerP3 = (Spinner) findViewById(R.id.spinnerP3);

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
        paginar++;
        if (paginar == 2) {
            txtGenero.setText("Sigamos con estos");
            txtP1.setText("Deporte favorito");
            opcionesP1 = new String[]{"Futbol", "Baloncesto", "Natacion", "Atletismo"};
            ArrayAdapter<String> adapterP1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesP1);
            spinnerP1.setAdapter(adapterP1);

            txtP1.setText("Hobbie favorito");
            opcionesP2 = new String[]{"Estudiar", "Gym", "Cantar", "Bailar"};
            ArrayAdapter<String> adapterP2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesP2);
            spinnerP2.setAdapter(adapterP2);

            txtP1.setText("Plan favorito");
            opcionesP3 = new String[]{"Netflix and chill", "Cine", "Rumba", "Comer"};
            ArrayAdapter<String> adapterP3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, opcionesP3);
            spinnerP3.setAdapter(adapterP3);
        } else if (paginar == 3) {
            spinnerP1.setEnabled(false);
            spinnerP2.setEnabled(false);
            spinnerP3.setEnabled(false);
            btnSiguiente.setText("Siguiente");
        }
    }

}