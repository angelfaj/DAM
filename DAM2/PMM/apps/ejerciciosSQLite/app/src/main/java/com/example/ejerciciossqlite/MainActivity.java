package com.example.ejerciciossqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        /*EJERCICIO 1:
        * Crear una BD en un contexto dado con una unica tabla con dos campos (entero y cadena)
        * Insertar 4 filas
        * Informar sin la BD ha sido creada o se ha producido algun error
        * Descargar la BD y comprobar que se ha creado correctamente con SQLite/Fiddle
        * Por ultimop actualizar la base de datos a la version 2*/
        /*
        Datos datos = new Datos(this, "test", null, 1);
        SQLiteDatabase testDb = datos.getWritableDatabase();

        datos.insertarFilasXDefecto(testDb);
        testDb.close();
        */
        /*EJERCICIO 2:
        * Aplicación para la gestión de bases de datos en la que se pueda:
        * Crear una base de datos a partir de su nombre escrito en un EditText.
        * Escribir sentencias SQL que no devuelvan resultados y que se ejecuten sobre la BD seleccionada (crear/eliminar tablas, insertar/actualizar/eliminar datos).
        * Para ello debes crear una función ejecutarSQL en la clase que gestione la bbdd (herede de SQLiteOpenHelper) que realice la ejecución de las sentencias escritas por el usuario.
        * Mediante mensajes se deberá informar de los errores que ocurran durante la ejecución.*/

        EditText entrada = findViewById(R.id.editText);
        Button btn = findViewById(R.id.crearBtn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreDb = entrada.getText().toString().trim();
                crearDB(MainActivity.this, nombreDb);
            }
        });


    }

    private  void crearDB(Context c, String nombreDB) {
        Datos d = new Datos(c, nombreDB, null, 1);
        SQLiteDatabase db = d.getWritableDatabase();
        d.ejecutarSQL(db);
        d.mostrarTablaJugador(db);
        db.close();
    }
}