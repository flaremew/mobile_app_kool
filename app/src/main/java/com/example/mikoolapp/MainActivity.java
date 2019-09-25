package com.example.mikoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button enKnap,enKnap2;
    TextView text;
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("savedInstanceState==" + savedInstanceState);
        setContentView(R.layout.activity_main);

        //webview
        webview = findViewById(R.id.webView);

        //knapper
        enKnap = findViewById(R.id.KoolButton);
        enKnap2 = findViewById(R.id.KoolButton2);

        enKnap.setOnClickListener(this);
        enKnap2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        System.out.println("Button is pressed, kool");

        text = findViewById(R.id.KoolText);

        if (v == enKnap){
            enKnap.setText("Hey, that's very kool");
            text.setText("Kool");

            Toast.makeText(this,"Super Kool", Toast.LENGTH_LONG).show();
        }
        if (v == enKnap2){
            enKnap2.setText("This is not very kool");
            text.setText("Not Kool");

            //webview
            webview.setWebViewClient(new MyWebViewClient());
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("https://javabog.dk");
        }
    }

    private class MyWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
