package com.example.descargahttp;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class DescargaThread extends AsyncTask<String, Void, String> {
    private TextView resultTxt;

    public DescargaThread(TextView resultTxt) {
        this.resultTxt = resultTxt;
    }

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
        resultTxt.setText(result);
    }

    private String leer(InputStream is) {
        try { ByteArrayOutputStream bo = new ByteArrayOutputStream();
            int i = is.read();
            while(i != -1) {
                bo.write(i);
                i = is.read();
            } return bo.toString();
        } catch (IOException e) { return ""; } }

    private String descargaUrl(String urlString) throws IOException {
        InputStream is = null;
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setReadTimeout(10000);
            conn.setConnectTimeout(15000);
            conn.setRequestMethod("GET");
            conn.setDoInput(true);
            conn.connect();
            int response = conn.getResponseCode();
            is = conn.getInputStream();

            return leer(is);
        } finally {
            if (is != null) {
                is.close();
            }
        }
    }
}
