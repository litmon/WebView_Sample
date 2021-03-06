package com.example.fukuokadota.webview_sample;

import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;

import im.delight.android.webview.AdvancedWebView;


public class MainActivity extends ActionBarActivity {

    WebView webView;
    FrameLayout placeholder;

    ValueCallback<Uri> mUploadMessage;
    ValueCallback<Uri[]> mFilePathCallback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate has called.", Toast.LENGTH_SHORT).show();

        placeholder = (FrameLayout) findViewById(R.id.placeholder);

        if (webView == null) {
            webView = new AdvancedWebView(this);
            webView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("google.com");
        }

        placeholder.addView(webView);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        if (webView != null) {
            placeholder.removeView(webView);
        }

        super.onConfigurationChanged(newConfig);

        setContentView(R.layout.activity_main);

        placeholder = (FrameLayout) findViewById(R.id.placeholder);
        placeholder.addView(webView);
    }
}
