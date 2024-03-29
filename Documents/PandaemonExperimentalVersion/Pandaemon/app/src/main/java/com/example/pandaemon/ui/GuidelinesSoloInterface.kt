package com.example.pandaemon.ui

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_guidelines_solo_interface.*
import com.example.pandaemon.R

class GuidelinesSoloInterface : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_guidelines_solo_interface)
        webViewSetup()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    @SuppressLint("SetJavaScriptEnabled")
    private fun webViewSetup() {
        wb_webView3.webViewClient = WebViewClient()

        wb_webView3.apply {
            loadUrl("https://covid19.gov.gr/")
            settings.javaScriptEnabled = true
            settings.safeBrowsingEnabled = true
        }

    }
    override fun onBackPressed() {
        if(wb_webView3.canGoBack()) wb_webView3.goBack() else super.onBackPressed()
    }
}