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

import com.example.listviews.R;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView miLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String [] provincias= new String[]{"Ciudad Real","Toledo","Guadalajara",
                "Cuenca","Albacete","Talavera"};

        ArrayAdapter<String> miAdaptador=new ArrayAdapter<String> (this,
                android.R.layout.simple_list_item_multiple_choice, provincias);

        miLista=findViewById(R.id.miLista); //IU
        miLista.setChoiceMode(AbsListView.CHOICE_MODE_MULTIPLE);
        //enfuchar adaptador a la vista
        miLista.setAdapter(miAdaptador);
        miLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView txtResultado=findViewById(R.id.txtResultado);
        String seleccionado= "";
        SparseBooleanArray checked = miLista.getCheckedItemPositions();
        if(checked!=null) {
            for (int i = 0; i < checked.size(); i++)
                if (checked.valueAt(i)) {
                    seleccionado = seleccionado +
                            miLista.getItemAtPosition(checked.keyAt(i)).toString()
                            + ";";
                }
        }
        txtResultado.setText(seleccionado);
    }
}