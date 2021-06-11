package com.example.pandaemon.ui

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.example.pandaemon.R
import kotlinx.android.synthetic.main.activity_google_form.*


class GoogleForm : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_google_form)

        webViewSetup()

    }
    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
private fun webViewSetup(){
    wb_webView.webViewClient = WebViewClient()

    wb_webView.apply {
        loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdACcR6Y4l6TN8hQ9TCuGETjQbEMuyIcWghBGkDoUgdYliPYw/viewform?usp=sf_link")
        settings.javaScriptEnabled = true
        settings.safeBrowsingEnabled = true
    }

}

    override fun onBackPressed() {
        if(wb_webView.canGoBack()) wb_webView.goBack() else super.onBackPressed()
    }


}