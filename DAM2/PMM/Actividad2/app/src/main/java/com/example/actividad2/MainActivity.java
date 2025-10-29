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
// ====================================Pregunta: ¿Como se puede implementar un listener mediante una clase anónima?==================================================================
//Respuesta breve:
// creando un objeto anónimo dentro del métdo setOnClickListenner
// no implementando la interfaz sobre la clase o no pasando 'this' como parámetro al establecer el listener, ya que esto hace que cada objeto que implemente ese listener se comportará de la misma forma
// si quisieramos que al hacer click sobre otro objeto de la misma clase se realizase una acción diferente necesitariamos impementar una clase anónima del siguiente modo:
//
// resetBtn.setOnClickListener(new View.OnClickListener() {    //Aqui estamos creando un objeto anónimo de la clase onclicklistener,
//            @Override                                        //de este modo podemos definir cualquier acción diferente a la estableciza
//            public void onClick(View view) {                 //por el método onClick en nuestra clase MainActivity
//                txtView = findViewById(R.id.myTextView);
//                resetedText = getString(R.string.reseted_text_txt);
//                txtView.setText(resetedText);
//            }
//        });