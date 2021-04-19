package com.example.pandaemon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun mainApp(view: View) {
        val intent = Intent(this, SidebarActivity::class.java)
        startActivity(intent)
    }
    fun uploadDataPage(view: View) {
        val intent = Intent(this, UploadData::class.java)
        startActivity(intent)
    }
}