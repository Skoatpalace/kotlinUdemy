package com.example.appliudemy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast

class WebViewActivity : AppCompatActivity() {

    lateinit var webView: WebView

    val webViewClient: WebViewClient = object : WebViewClient() {

        override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
            Log.i("WebViewActivity", "Loading URL: $url")

            val containsStudio = url?.contains("studio") ?: false
            if (containsStudio){
                Toast.makeText(this@WebViewActivity, "Chargement android studio", Toast.LENGTH_SHORT).show()
            }

            return super.shouldOverrideUrlLoading(view, url)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        webView = findViewById(R.id.web_view)
        webView.webViewClient = webViewClient

        val settings = webView.settings
        settings.javaScriptEnabled = true

        webView.loadUrl("https://developer.android.com")
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {

        if (keyCode == KeyEvent.KEYCODE_BACK && webView.canGoBack()){
            webView.goBack()
            return true
        }

        return super.onKeyDown(keyCode, event)
    }
}
