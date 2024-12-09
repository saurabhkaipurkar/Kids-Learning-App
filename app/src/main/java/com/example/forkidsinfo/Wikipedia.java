package com.example.forkidsinfo;

import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.appcompat.app.AppCompatActivity;
public class Wikipedia extends AppCompatActivity {
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);

        webview = findViewById(R.id.page_view);
        // Force links and redirects to open in WebView instead of a browser
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return !request.getUrl().toString().startsWith("http://www.wikipedia.org/") && !request.getUrl().toString().startsWith("https://www.wikipedia.org/");
            }
        });
        webview.loadUrl("https://www.wikipedia.org/");
    }
    public void onBackPressed() {
        if (webview.canGoBack()) {
            webview.goBack();
        } else {
            super.onBackPressed();
        }
    }
}