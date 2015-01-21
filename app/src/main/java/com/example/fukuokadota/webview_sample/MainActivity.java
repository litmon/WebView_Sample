package com.example.fukuokadota.webview_sample;

import android.content.res.Configuration;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    WebView webView;
    FrameLayout placeholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(this, "onCreate has called.", Toast.LENGTH_SHORT).show();

        placeholder = (FrameLayout) findViewById(R.id.placeholder);

        if (webView == null) {
            webView = new WebView(this);
            webView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            webView.setWebViewClient(new WebViewClient());
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("http://syncer.jp/_demo/javascript/jquery-modal-window/modal.html");
        }

        placeholder.addView(webView);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        Toast.makeText(this, "onRestoreInstanceState has called.", Toast.LENGTH_SHORT).show();

        super.onRestoreInstanceState(savedInstanceState);
        webView.restoreState(savedInstanceState);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        Toast.makeText(this, "onSaveInstanceState has called.", Toast.LENGTH_SHORT).show();

        super.onSaveInstanceState(outState);
        webView.saveState(outState);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        Toast.makeText(this, "onConfigurationChanged has called.", Toast.LENGTH_SHORT).show();

        if (webView != null) {
            placeholder.removeView(webView);
        }

        super.onConfigurationChanged(newConfig);

        setContentView(R.layout.activity_main);

        placeholder = (FrameLayout) findViewById(R.id.placeholder);
        placeholder.addView(webView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
