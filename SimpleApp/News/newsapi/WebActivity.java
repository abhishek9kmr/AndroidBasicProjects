package com.example.abhishekkumar.newsapi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        webView=(WebView)findViewById(R.id.webView);
        //WEB VIEW DISPLAYS
        webView.loadUrl(getIntent().getStringExtra("WEBURL"));
        //NAVIGATING TO OTHER PAGES WITHIN THE WEB VIEW
        webView.setWebViewClient(new WebViewClient());}
        //ADD THIS OTHERWISE WEB VIEW GETS CLOSED ON BACK PRESS

    @Override
    public void onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack();
            return;
        }
        super.onBackPressed();
    }
}

