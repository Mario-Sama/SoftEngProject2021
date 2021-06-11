package com.example.pandaemon.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_guidelines_solo_interface.*
import com.example.pandaemon.R
import kotlinx.android.synthetic.main.activity_news_solo_interface.*

class NewsSoloInterface : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_solo_interface)
        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {
        wb_webView4.webViewClient = WebViewClient()

        wb_webView4.apply {
            loadUrl("https://www.google.com/search?q=covid-19+%CE%B5%CE%BB%CE%BB%CE%AC%CE%B4%CE%B1&oq=cov&aqs=edge.0.69i59j69i57j0i433l3j0i131i433j0i433.6126j0j1&sourceid=chrome&ie=UTF-8")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }

    }
    override fun onBackPressed() {
        if(wb_webView4.canGoBack()) wb_webView4.goBack() else super.onBackPressed()
    }
}