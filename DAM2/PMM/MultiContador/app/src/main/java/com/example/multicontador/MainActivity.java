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
    private int contadorGlobal, contador1, contador2, contador3, contador4;
    private TextView txtContadorGlobal, txtContador1, txtContador2, txtContador3, txtContador4;
    private Button btnAumentarContador1, btnAumentarContador2, btnAumentarContador3, btnAumentarContador4;
    private Button btnResetAll, btnResetContador1, btnResetContador2, btnResetContador3, btnResetContador4;
    
    Despues de modificar el metodo aumentar y disminuir la app se cierra al hacer click en cualquier boton
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
        txtContador1 = findViewById(R.id.txtContador1);
        txtContador2 = findViewById(R.id.txtContador2);
        txtContador3 = findViewById(R.id.txtContador3);
        txtContador4 = findViewById(R.id.txtContador4);
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
        contadorGlobal = 0;
        contador1 = 0;
        contador2 = 0;
        contador3 = 0;
        contador4 = 0;
    }
    private void agregarListeners() {
        btnAumentarContador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(contador1, txtContador1);
            }
        });

        btnAumentarContador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(contador2, txtContador2);
            }
        });

        btnAumentarContador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(contador3, txtContador3);
            }
        });

        btnAumentarContador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                aumentarContador(contador4, txtContador4);
            }
        });

        btnResetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(contadorGlobal, txtContadorGlobal);
            }
        });
        
        btnResetContador1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(contador1, txtContador1);
            }
        });
        
        btnResetContador2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(contador2, txtContador2);
            }
        });

        btnResetContador3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(contador3, txtContador3);
            }
        });

        btnResetContador4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetContador(contador4, txtContador4);
            }
        });
    }

    private void resetAll() {
        //Reseteamos contadores
        int[] contadores = {contador1, contador2, contador3, contador4};
        TextView[] txtContadores = {txtContador1, txtContador2, txtContador3, txtContador4};

        for (int i = 0; i < contadores.length; i++) {
            resetContador(contadores[i], txtContadores[i]);
        }
        //Reseteamos contador global
        contadorGlobal = 0;
        //Actualizamos registros
        txtContadorGlobal.setText(contadorGlobal);

    }
    private void resetContador(int cont, TextView txtContador) {
        //Aumentamos contadores
        contadorGlobal -= cont;
        cont = 0;
        //Actualizamos registros
        txtContador.setText(cont);
        txtContadorGlobal.setText(contadorGlobal);
    }
    private void aumentarContador(int cont, TextView txtContador) {
        //Aumentamos contadores
        contadorGlobal++;
        cont++;
        //Actualizamos registros
        txtContador.setText(cont);
        txtContadorGlobal.setText(contadorGlobal);
    }
   
}