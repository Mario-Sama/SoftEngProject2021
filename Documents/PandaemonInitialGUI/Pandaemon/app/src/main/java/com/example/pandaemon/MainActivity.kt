package com.example.pandaemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uploadbutton = findViewById<Button>(R.id.uploadbutton)
        uploadbutton.setOnClickListener {
            val intent = Intent(  this, UploadDataWindow::class.java)
            startActivity(intent)

            val staysafebutton = findViewById<Button>(R.id.staysafebutton)
            staysafebutton.setOnClickListener {
                val intent2 = Intent(this, UploadDataWindow::class.java)
                startActivity(intent2)
            }
        }

    }
}