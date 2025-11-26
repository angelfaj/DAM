package com.example.examenact1;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button incrementoBoton;
    private Button decrementoBoton;
    private Button cuandoBoton;
    private TextView textview;

    private int contador = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);;
        incrementoBoton = findViewById(R.id.botonIncremento);
        decrementoBoton = findViewById(R.id.botonDecremento);
        cuandoBoton = findViewById(R.id.botonCuando);

        //Añadimos el listener
        incrementoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                mostrarTiempo();
            }
        });

        //Añadimos el listener
        decrementoBoton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador--;
                if (contador == 0) {
                    contador++;
                }
                mostrarTiempo();
            }
        });
    }

    private void mostrarTiempo() {
        textview.setText("Tiempo: "+ contador);
    }
}