package com.example.mikoolapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    Button enKnap,enKnap2,enKnap3;
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
        enKnap3 = findViewById(R.id.KoolButton3);

        enKnap.setOnClickListener(this);
        enKnap2.setOnClickListener(this);
        enKnap3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        System.out.println("Button is pressed, kool");

        text = findViewById(R.id.KoolText);

        if (v == enKnap){
            enKnap.setText("Hey, that's very kool");
            text.setText("Kool");

            Toast.makeText(this,"Super Kool", Toast.LENGTH_LONG).show();

            // Build the intent

            Uri webpage = Uri.parse("http://www.android.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            // Verify it resolves
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(webIntent, 0);
            boolean isIntentSafe = activities.size() > 0;

            // Start an activity if it's safe
            if (isIntentSafe) {
                startActivity(webIntent);
            }

        }
        if (v == enKnap2){
            enKnap2.setText("This is not very kool");
            text.setText("Not Kool");

            //webview
            webview.setWebViewClient(new MyWebViewClient());
            webview.getSettings().setJavaScriptEnabled(true);
            webview.loadUrl("https://javabog.dk");


        }

        if (v == enKnap3){
            // eksplicit aktivity (virker ikke)
            Intent i = new Intent(this, Hjaelp_akt.class);
            // Verify it resolves
            PackageManager packageManager = getPackageManager();
            List<ResolveInfo> activities = packageManager.queryIntentActivities(i, 0);
            boolean isIntentSafe = activities.size() > 0;

            if (isIntentSafe) {
                startActivity(i);
            }
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
