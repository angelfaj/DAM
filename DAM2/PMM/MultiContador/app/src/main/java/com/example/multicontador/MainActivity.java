package com.example.multicontador;

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
    private TextView txtContadorGlobal, txtContador1, txtContador2, txtContador3, txtContador4;
    private TextView[] txtContadores;
    private int contadorGlobal = 0;
    private int[] contadores = new int[4]; //0 sera el siguiente al contador global, 2 el siguiente ...
    private Button btnAumentarContador1, btnAumentarContador2, btnAumentarContador3, btnAumentarContador4;
    private Button btnResetAll, btnResetContador1, btnResetContador2, btnResetContador3, btnResetContador4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Asignamos los elementos a las variables
        enlazarElementos();
        //Creamos los listeners
        agregarListeners();

    }
    private void enlazarElementos() {
        txtContadorGlobal = findViewById(R.id.txtContadorGlobal);
        txtContadores = new TextView[] {
                findViewById(R.id.txtContador1),
                findViewById(R.id.txtContador2),
                findViewById(R.id.txtContador3),
                findViewById(R.id.txtContador4)
        };
        btnAumentarContador1 = findViewById(R.id.btnContador1);
        btnAumentarContador2 = findViewById(R.id.btnContador2);
        btnAumentarContador3 = findViewById(R.id.btnContador3);
        btnAumentarContador4 = findViewById(R.id.btnContador4);
        btnResetAll  = findViewById(R.id.btnResetAll);
        btnResetContador1 = findViewById(R.id.btnReset1);
        btnResetContador2 = findViewById(R.id.btnReset2);
        btnResetContador3 = findViewById(R.id.btnReset3);
        btnResetContador4 = findViewById(R.id.btnReset4);
        //Inicializamos los contadores
        for (int i = 0; i < contadores.length; i++) {
            contadores[i] = 0;
        }
    }
    private void agregarListeners() {
        btnAumentarContador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(0);
            }
        });

        btnAumentarContador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(1);
            }
        });

        btnAumentarContador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(2);
            }
        });

        btnAumentarContador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(3);
            }
        });

        btnResetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetAll(contadores);
            }
        });

        btnResetContador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(0);
            }
        });

        btnResetContador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(1);
            }
        });

        btnResetContador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(2);
            }
        });

        btnResetContador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(3);
            }
        });
    }

    private void resetAll(int[] contadores) {
        //Reseteamos los contradores
        for (int i = 0; i < contadores.length; i++) {
            resetContador(i);
        }
    }
    private void resetContador(int index) {
        //Disminuimos contadores
        contadorGlobal -= contadores[index];
        contadores[index] = 0;
        //Actualizamos registros
        txtContadores[index].setText(String.valueOf(contadores[index]));
        txtContadorGlobal.setText(String.valueOf(contadorGlobal));
    }
    private void aumentarContador(int index) {
        //Aumentamos contadores
        contadores[index] += 1;
        contadorGlobal++;

        //Actualizamos registros
        txtContadores[index].setText(String.valueOf(contadores[index]));
        txtContadorGlobal.setText(String.valueOf(contadorGlobal));
    }
   
}