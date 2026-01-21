package com.example.ejerciciossqlite;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class Datos extends SQLiteOpenHelper {
    public static final String TABLE_JUGADORES = "jugador";

    public Datos(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String crearTabla = "CREATE TABLE jugador(" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nombre VARCHAR(30) NOT NULL," +
                "pais VARCHAR(20))";

        db.execSQL(crearTabla);
        insertarDatosXDefecto();
        Log.i("MI_APP","Base de datos creada y datos insertados");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("MI_APP", "Base de datos actualizada correctamente");
    }

    public void insertarDatosXDefecto() {
        SQLiteDatabase db = this.getWritableDatabase();

        String nombre = "John-";
        String pais = "pais-";
        posible error aqui por no insertar id!!!!
        String insert = "INSERT INTO jugador(nombre, pais) VALUES(";
        for (int i = 1; i <= 6; i++) {
            String insertTemp = insert + "'" + nombre + i + "', '" + pais + i + "')";
            db.execSQL(insertTemp);
        }
        Log.i("MI_APP","Filas insertadas");
    }

    public Cursor mostrarTablaJugador() {
        SQLiteDatabase db = this.getReadableDatabase();
        String select = "SELECT * FROM " + TABLE_JUGADORES;

        return db.rawQuery(select, null);
    }
}
