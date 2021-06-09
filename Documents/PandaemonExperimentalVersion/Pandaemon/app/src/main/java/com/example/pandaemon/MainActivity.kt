package com.example.pandaemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pandaemon.GuidelinesSoloInterface




class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val uploadbutton = findViewById<Button>(R.id.uploadbutton)
        uploadbutton.setOnClickListener {
            val intent = Intent(this, UploadDataWindow::class.java)
            startActivity(intent)
        }

            val staysafebutton = findViewById<Button>(R.id.staysafebutton)
            staysafebutton.setOnClickListener {
                val intent = Intent(this, Drawer::class.java)
                startActivity(intent)
            }

/*
        Run this for alternating between Drawer and SaftetyReview Interface
        val staysafebutton = findViewById<Button>(R.id.staysafebutton)
        staysafebutton.setOnClickListener {
            val intent = Intent(this, SafetyReviewInterface::class.java)
            startActivity(intent)
        }
*/

        val delete = findViewById<Button>(R.id.deleteit)
       delete.setOnClickListener {
            val intent = Intent(this, GuidelinesSoloInterface::class.java)
            startActivity(intent)
       }





    }
}