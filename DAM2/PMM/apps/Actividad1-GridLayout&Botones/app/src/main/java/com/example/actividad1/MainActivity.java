package com.example.actividad1;

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
    /*Practica1:
    Cáso práctico y sencillo para comprobar el uso de eventos listener en un GridLayout.
    En clase ya hemos visto los distintos tipos de Layout que existen para usar como contenedores de widgets hijos.
    Objetivo: Realizar una aplicación que utilizando la clase Button y GridLayout de Android cree de forma programada y modificable entre 6 y 21 botones con diferentes colores. Al pulsar cada uno de ellos, se pondrán de color blanco. El nombre de cada uno de ellos puede ser enumerado o en orden alfabético, pero tiene que tener escrito unas letras o numeros encima.
    La nota completa del ejercicio se consigue programando un último botón llamado "RESET" que al pulsar, volverá a la configuración con colores.
    Lo vamos a ir resolviendo en clase poco a poco pero sin pausa.
     */
    private GridLayout gLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Enlazamos el layout con su objeto
        gLayout = findViewById(R.id.miGridLayout);
        //Establecemos el numero de botones a crear
        int numeroBotones = (int) (Math.random() * 16) + 6;//Entre 6 y 21

        //Creamos una lista para almacenar nuestros botones
        ArrayList<Button> botonesList = new ArrayList<Button>();
        crearNBotones(numeroBotones, botonesList);

        //Creamos el boton de reset
        Button resetButton = new Button(this);
        resetButton.setText(getString(R.string.reset_button));
        resetButton.setBackgroundColor(Color.RED);
        asignarTamanioYMargen(resetButton);
        //Añadimos el listener
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(Button b:botonesList) {
                    //Eliminamos el color de fondo
                    b.setBackgroundColor(Color.CYAN);
                }
            }
        });
        //Añadimos el boton a la vista
        gLayout.addView(resetButton);
    }

    private void crearNBotones(int numeroBotones, ArrayList<Button> botonesList) {
        for (int i = 0; i < numeroBotones; i++) {
            //Creamos una variable local para evitar que el listener apunte al ultimo elemento creado
            Button boton = new Button(this); //Le pasamos el contexto this que es la Activity para que Andorid sepa donde crearlo. Es una forma de decirle a que pertenece ese boton
            botonesList.add(boton);
            //Añadimos un texto al boton Y lo pintamos de cyan
            boton.setText(String.valueOf("B" + (i + 1)));
            boton.setBackgroundColor(Color.CYAN);
            //Establecemos el tamaño de los botones para que ocupen todos lo mismo
            asignarTamanioYMargen(boton);

            //Añadimos el listener
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //Lo pintamos de blanco al hacer click
                    boton.setBackgroundColor(Color.WHITE);
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