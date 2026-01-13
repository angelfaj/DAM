package com.example.ejerciciossqlite;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{

    /*
    EJERCICIO 1:
    * Crear una BD en un contexto dado con una unica tabla con dos campos (entero y cadena)
    * Insertar 4 filas
    * Informar sin la BD ha sido creada o se ha producido algun error
    * Descargar la BD y comprobar que se ha creado correctamente con SQLite/Fiddle
    * Por ultimop actualizar la base de datos a la version 2
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Datos datos = new Datos(this, "test", null, 1);
        SQLiteDatabase testDb = datos.getWritableDatabase();

        datos.insertarFilasXDefecto(testDb);

    }
}