package com.example.pandaemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.pandaemon.ui.GuidelinesSoloInterface
import com.example.pandaemon.ui.NewsSoloInterface


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

        val deletes = findViewById<Button>(R.id.deleteit)
       deletes.setOnClickListener {
            val intent = Intent(this, NewsSoloInterface::class.java)
            startActivity(intent)
       }


    }
}