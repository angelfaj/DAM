package com.example.listviews;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //Esta app es un ejemplo de como utilizar listas multiples (de multiple selección) y
    // listas simples (seleccion de un objeto que desencadena una acción)


    ListView miListaMultiple;
    ListView miListaSimple;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] provincias= new String[]{"Ciudad Real","Toledo","Guadalajara",
                "Cuenca","Albacete","Talavera"};

        ArrayAdapter<String> miAdaptadorMultiple =new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_multiple_choice, provincias);

        miListaMultiple =findViewById(R.id.miListaMultiple); //IU
        miListaMultiple.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        //enfuchar adaptador a la vista
        miListaMultiple.setAdapter(miAdaptadorMultiple);
        miListaMultiple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtResultado=findViewById(R.id.txtResultadoListaMultiple);
                String seleccionado= "";
                SparseBooleanArray checked = miListaMultiple.getCheckedItemPositions();
                if(checked!=null) {
                    for (int i = 0; i < checked.size(); i++)
                        if (checked.valueAt(i)) {
                            seleccionado = seleccionado +
                                    miListaMultiple.getItemAtPosition(checked.keyAt(i)).toString()
                                    + ";";
                        }
                }
                txtResultado.setText(seleccionado);
            }
        });

        miListaSimple =findViewById(R.id.miListaSimple); //IU
        ArrayAdapter<String> miAdaptadorSimple = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, provincias);

        //enfuchar adaptador a la vista
        miListaSimple.setAdapter(miAdaptadorSimple);
        miListaSimple.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Toast.makeText(MainActivity.this,
                        "Se ha pulsado " + provincias[position],
                        Toast.LENGTH_SHORT).show();

                TextView txtResultadoSimple = findViewById(R.id.txtResultadoListaSimple);
                txtResultadoSimple.setText(provincias[position]);
            }
        });


    }

}