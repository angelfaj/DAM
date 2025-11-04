package com.example.recordatorios;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
// La idea es crear una app que sirva como recordatorios en la que poder añadir o eliminar tareas, pudiento mostrar las marcadas como hechas y las pendientes
   private ListView listaTareas;
   private Button hechasBtn;
   private Button pendientesBtn;
   private Button addBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        listaTareas = findViewById(R.id.listaPrincipal);
        hechasBtn = findViewById(R.id.hechas_btn);
        pendientesBtn = findViewById(R.id.pendientes_btn);
        addBtn = findViewById(R.id.add_btn);
    }

    public void addListeners() {
        listaTareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}