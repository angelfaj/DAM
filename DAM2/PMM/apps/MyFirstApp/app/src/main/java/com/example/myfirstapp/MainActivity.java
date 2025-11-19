package com.example.myfirstapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText txtNombre;
    private Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Obtenemos una referencia a los controles de la interfaz
        txtNombre = findViewById(R.id.txtNombre);
        btnAceptar = findViewById(R.id.btnAceptar);

        btnAceptar.setOnClickListener(view -> {
            //Creamos el intent
            Intent intent = new Intent(MainActivity.this, SaludoActivity.class);

            //Añadimos al intent la información para pasar entre actividades
            intent.putExtra("NOMBRE", txtNombre.getText().toString());

            //In iciamos la nueva actividad
            startActivity(intent);

        });
    }
}