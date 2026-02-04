package com.example.descargahttp;

import android.os.AsyncTask;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DescargaThread extends AsyncTask<String, Void, String> {
    @Override
    protected String doInBackground(String... urls) {
        try {
            return descargaUrl(urls[0]);
        } catch (IOException e) {
            return "Unable to retrieve web page. URL may be invalid.";
        }
    }

    @Override
    protected void onPostExecute(String result) {
        txtDescarga.setText(result);
    }

    //clase DescargaPaginaWeb extends AsyncTask<String, Void, String> (3/6)
    /** Este método lee todo el inputstream convirtiéndolo en una cadena
     ayudándonos con un ByteArrayOutputStream() */
    private String leer(InputStream is) {
        try { ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            } return bo.toString();
        } catch (IOException e) { return ""; } }

    //clase DescargaPaginaWeb extends AsyncTask<String, Void, String> (4/6)
        // Dada una URL, establece una conexión HttpUrlConnection y devuelve
        // el contenido de la página web con un InputStream, y que se transforma a un String.
    private String descargaUrl(String myurl) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(myurl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000 /* milisegundos */);
            conn.setConnectTimeout(15000 /* milisegundos */);
            //clase DescargaPaginaWeb extends AsyncTask<String, Void, String> (5/6)
            // continuación método descargaUrl
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            // comienza la consulta
            conn.connect();
            int response = conn.getResponseCode();
            is = conn.getInputStream();
            // convertir el InputStream a string
            return leer(is);
            //clase DescargaPaginaWeb extends AsyncTask<String, Void, String> (6/6)
            // continuación método descargaUrl
            //Nos aseguramos de cerrar el inputStream.
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
