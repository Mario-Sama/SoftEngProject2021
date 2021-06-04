package com.example.pandaemon

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


public class UploadDataWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_data_window)

        val actionBar = supportActionBar

       actionBar!!.title = "Upload Data Window"
        actionBar.setDisplayHomeAsUpEnabled(true)


        }
    }