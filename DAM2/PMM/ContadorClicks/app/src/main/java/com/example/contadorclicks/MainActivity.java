package com.example.contadorclicks;

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
    private int contador;
    private TextView textContador;
    private Button btnAumentarContador;
    private String textInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textContador = findViewById(R.id.contadorDeClicks);
        btnAumentarContador = findViewById(R.id.aumentarContador);

        btnAumentarContador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                contador++;
                textInfo = getString(R.string.click_count, contador);
                textContador.setText(textInfo);
            }
        });
    }
}