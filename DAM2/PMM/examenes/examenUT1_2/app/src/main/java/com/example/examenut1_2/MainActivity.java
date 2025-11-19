package com.example.examenut1_2;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    //Aplicacion 2 del examen


    private GridLayout gLayout;

    ArrayList<Color> coloresList = new ArrayList<Color>();
    private int contador = 0;
    private int r, g, b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Enlazamos el layout con su objeto
        gLayout = findViewById(R.id.miGridLayout);
        //Establecemos el numero de botones a crear
        int numeroBotones = 9;

        //Creamos una lista para almacenar nuestros botones
        ArrayList<Button> botonesList = new ArrayList<Button>();

        //Creamos el boton de reset
        Button resetButton = new Button(this);
        resetButton.setText(getString(R.string.reset_button) + contador);
        resetButton.setBackgroundColor(Color.RED);
        asignarTamanioYMargen(resetButton);
        //Añadimos el listener
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Eliminamos el color de fondo
                resetButton.setBackgroundColor(Color.WHITE);
            }
        });
        crearNBotones(numeroBotones, botonesList, resetButton);
        //Añadimos el boton a la vista
        gLayout.addView(resetButton);
    }

    private void crearNBotones(int numeroBotones, ArrayList<Button> botonesList, Button resetButton) {
        for (int i = 0; i < numeroBotones; i++) {
            //Creamos una variable local para evitar que el listener apunte al ultimo elemento creado
            Button boton = new Button(this); //Le pasamos el contexto this que es la Activity para que Andorid sepa donde crearlo. Es una forma de decirle a que pertenece ese boton
            botonesList.add(boton);
            //Añadimos un texto al boton, lo pintamos
            boton.setText(String.valueOf("B" + (i + 1)));
            r =  (int) (Math.random() * 255) + 1;
            g =  (int) (Math.random() * 255) + 1;
            b =  (int) (Math.random() * 255) + 1;
            //Color color = Color.valueOf(Color.rgb(r, g ,b));
            //coloresList.add(color);
            //Establecemos el tamaño de los botones para que ocupen todos lo mismo
            boton.setBackgroundColor(Color.rgb(r, g ,b));
            asignarTamanioYMargen(boton);

            //Añadimos el listener
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    contador++;
                    String textoContador = getString(R.string.reset_button) + contador;
                    resetButton.setText(textoContador);
                    //Pintamos el boton reset
                    resetButton.setBackgroundColor(Color.rgb(r, g, b));
                }
            });

            //Por ultimo añadimos el boton a nuestro layout
            gLayout.addView(boton);
        }
    }

    private void asignarTamanioYMargen(Button boton) {
        GridLayout.LayoutParams params = new GridLayout.LayoutParams();
        params.width = 0;
        params.height = GridLayout.LayoutParams.WRAP_CONTENT;
        params.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f);
        boton.setLayoutParams(params);
    }
}