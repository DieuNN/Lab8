package com.example.lab8;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class Browse extends AppCompatActivity {
    WebView webView;
    EditText edtUrl;
    Button browse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_browse);
        mapping();
        edtUrl.setText("https://");

        browse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                webView.loadUrl(edtUrl.getText().toString());
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        edtUrl.setText(url);
                    }
                });
            }
        });
    }

    private void mapping() {
        webView = findViewById(R.id.webView);
        edtUrl = findViewById(R.id.txtUrl);
        browse = findViewById(R.id.btnBrowse);
    }
}