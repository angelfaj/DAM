package com.example.actividad2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String resetedText;
    private Button resetBtn;
    private TextView txtView;
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

        resetBtn = findViewById(R.id.btnReset);
        resetBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        txtView = findViewById(R.id.myTextView);
        resetedText = getString(R.string.reseted_text_txt);
        txtView.setText(resetedText);
    }
}
// =====================Pregunta: ¿Como se puede implementar un listener mediante una clase anónima?====================
//Respuesta breve:
// creando un objeto anónimo del listener que queremos utilizar, por ejemplo dentro del método setOnClickListenner (también se puede crear fuera)
// en nuestro código quedaría de la siguiente forma:

// resetBtn.setOnClickListener(new View.OnClickListener() {    //Aqui estamos creando un objeto anónimo de la clase onclicklistener,
//            @Override                                        //de este modo podemos definir cualquier acción diferente a la estableciza
//            public void onClick(View view) {                 //por el método onClick en nuestra clase MainActivity
//                txtView = findViewById(R.id.myTextView);
//                resetedText = getString(R.string.reseted_text_txt);
//                txtView.setText(resetedText);
//            }
//        });

// Ventajas de la implementación anónima: Extiende la funcionalidad de nuestra app ya que podemos establecer comportamientos diferentes para un mismo tipo de listener
// Ventajas de implementar el listener en la clase: Sencillez y legibilidad, es útil cuando el listener tiene un único comportamiento, también puede servirnos para definir comportamientos genéricos.