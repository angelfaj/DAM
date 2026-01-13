package com.example.ejerciciossqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Datos extends SQLiteOpenHelper {
    public Datos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTabla = "CREATE TABLE departamento(idDep INTEGER PRIMARY KEY, nombre VARCHAR(30))";
        db.execSQL(crearTabla);
        System.out.println("Tabla departamento creada");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        System.out.println("Base de datos actualizada correctamente");
    }

    public void insertarFilasXDefecto(SQLiteDatabase db) {
        int idDep;
        String nombre = "departamento-";
        String insert = "INSERT INTO departamento(idDep, nombre) VALUES(";
        for (idDep = 1; idDep <= 4; idDep++) {
            String insertTemp = insert + idDep + ", '" + nombre + idDep + "')";
            db.execSQL(insertTemp);
        }
    }
}
