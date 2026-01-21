package com.example.ejerciciossqlite;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity{

    private Datos dao;

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

        EditText dbName = findViewById(R.id.txtDbName);
        TextView mostrarTabla = findViewById(R.id.txtTable);
        Button createBtn = findViewById(R.id.crearBtn);
        Button showBtn = findViewById(R.id.mostrarBtn);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombreDb = dbName.getText().toString().trim();
                if (dao != null && dao.getDatabaseName().equalsIgnoreCase(nombreDb)) {
                    mostrarTabla.setText("La base de datos " + nombreDb + " ya existe, inserta un nombre diferente.");
                }else {
                    dao = new Datos(MainActivity.this, nombreDb, null, 1);
                    mostrarTabla.setText("Base de datos " + nombreDb + " creada.");
                }
            }
        });

        showBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dao == null) {
                    mostrarTabla.setText("Debes crear la base de dabos primero");
                }else {
                    Cursor c = dao.mostrarTablaJugador();
                    if (c != null && c.moveToFirst()) {
                        StringBuilder resul = new StringBuilder();
                        int i = 0;
                        do {
                            int id = c.getInt(0);
                            String name = c.getString(1);
                            String pais = c.getString(2);
                            resul.append("Resultado")
                                    .append(i)
                                    .append(": ")
                                    .append(id)
                                    .append(":")
                                    .append(name)
                                    .append(":")
                                    .append(pais)
                                    .append("\n");
                        }while (c.moveToNext());

                        mostrarTabla.setText(resul.toString());
                    }
                    c.close();
                }
            }
        });


    }
}