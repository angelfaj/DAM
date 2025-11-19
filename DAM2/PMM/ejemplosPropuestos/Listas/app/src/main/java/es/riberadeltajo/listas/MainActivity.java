package es.riberadeltajo.listas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView miLista;

    String [] provincias= new String[]{"Ciudad Real","Toledo","Guadalajara",
                                            "Cuenca","Albacete","Talavera"}; //Datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miLista=findViewById(R.id.miLista); //IU

        ArrayAdapter<String> miAdaptador=new ArrayAdapter<String>(
                this, R.layout.fila,provincias); //Adaptador


        //enfuchar adaptador a la vista
        miLista.setAdapter(miAdaptador);
        miLista.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Se ha pulsado "+ provincias[position],Toast.LENGTH_SHORT).show();
        String s=((TextView)view).getText().toString();

    }
}