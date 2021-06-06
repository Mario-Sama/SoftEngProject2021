package com.example.ermistest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val safetyReview = findViewById<EditText>(R.id.safetyReviewText)
        val uploadSafetyReview = findViewById<Button>(R.id.buttonUploadSafety)
        uploadSafetyReview.setOnClickListener {
            //dispMessage.setText("The Safety Review has been uploaded")
            val toast1 = Toast.makeText(applicationContext, "The Safety Review has been uploaded", Toast.LENGTH_LONG)
            toast1.setGravity(Gravity.CENTER, 0,0)
            toast1.show()
        }
    }
}