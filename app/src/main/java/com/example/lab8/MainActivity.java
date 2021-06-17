package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button toBrowseActivity, toGetHttpRequestActivity;
    Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mapping();

        toBrowseActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Browse.class));

            }
        });

        toGetHttpRequestActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, GetHttpRequest.class));
            }
        });

    }

    private void mapping() {
        toBrowseActivity = findViewById(R.id.btnToBrowseActivity);
        toGetHttpRequestActivity = findViewById(R.id.btnToGetHttpRequestActivity);
    }
}