package com.example.recordatorios;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
// La idea es crear una app que sirva como recordatorios en la que poder añadir o eliminar tareas, pudiento mostrar las marcadas como hechas y las pendientes
   private ListView tareasListView;
   private ArrayList<String> tareasAllArrayList;
   private Button hechasBtn;
   private Button pendientesBtn;
   private Button addBtn;
   private EditText tareaTxt;
   private ArrayAdapter<String> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tareasListView = (ListView) findViewById(R.id.listaPrincipal);
        hechasBtn = findViewById(R.id.hechas_btn);
        pendientesBtn = findViewById(R.id.pendientes_btn);
        addBtn = findViewById(R.id.add_btn);
        tareaTxt = findViewById(R.id.tareaTxt);
        tareasAllArrayList = new ArrayList<String>();

        addListeners();
    }

    public void addListeners() {
        tareasListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //https://naps.com.mx/blog/uso-de-un-listview-en-android/
                //https://umhandroid.momrach.es/listview-simple/

            }
        });
        /*
        hechasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        pendientesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        */
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String tarea = String.valueOf(tareaTxt.getText());
                tareasAllArrayList.add(tarea);
                tareaTxt.setText("");
                addTarea();
            }
        });
    }

    public void addTarea(){
        adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tareasAllArrayList);
        tareasListView.setAdapter(adaptador);
    }
}