package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class GetHttpRequest extends AppCompatActivity {
    TextView getHttpRequest;
    Button sentRequest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_http_request);
        mapping();

        sentRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "https://genk.vn";
                AsyncTask task = new AsyncTask() {
                    @Override
                    protected Object doInBackground(Object[] objects) {
                        try {
                            URL url1 = new URL(url);
                            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url1.openConnection();
                            InputStream inputStream = httpsURLConnection.getInputStream();
                            Scanner scanner = new Scanner(inputStream);
                            String data = "";
                            while (scanner.hasNext()) {
                                data+=scanner.nextLine();

                            }
                            scanner.close();
                            return data;
                        } catch (MalformedURLException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return null;
                    }

                    @Override
                    protected void onPostExecute(Object o) {
                        super.onPostExecute(o);
                        getHttpRequest.setText(o.toString());
                    }
                };
                task.execute();
            }
        });


    }

    private void mapping() {
        getHttpRequest = findViewById(R.id.lblGetHttpRequest);
        sentRequest = findViewById(R.id.btnSendHttpRequest);
    }
}