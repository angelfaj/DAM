package com.example.descargahttp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

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

    }

    //método onclick del botón descargar para poner en la clase MainActiviry (1/2)
    public void descargar(View v){
        edURL=(EditText)findViewById(R.id.edURL);
        txtDescarga=(TextView) findViewById(R.id.txtDescarga);
        txtDescarga.setMovementMethod(new ScrollingMovementMethod());
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        //método onclick del botón descargar para poner en la clase MainActiviry (2/2)
        if (networkInfo != null && networkInfo.isConnected()) {
            new DescargaPaginaWeb().execute(edURL.getText().toString());
        } else {
            edURL.setText("No se ha podido establecer conexión a internet");
        }
    }
}