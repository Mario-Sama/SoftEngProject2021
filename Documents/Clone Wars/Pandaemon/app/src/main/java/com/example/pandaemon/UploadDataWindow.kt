package com.example.pandaemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pandaemon.ui.GoogleForm


public class UploadDataWindow : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_data_window)

        val actionBar = supportActionBar

       actionBar!!.title = "Upload Data Window"
        actionBar.setDisplayHomeAsUpEnabled(true)

        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            val intent = Intent(this, GoogleForm::class.java)
            startActivity(intent)
        }

        }
    }