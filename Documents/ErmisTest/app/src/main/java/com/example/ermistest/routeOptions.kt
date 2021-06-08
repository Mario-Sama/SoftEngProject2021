package com.example.ermistest

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalTime

class routeOptions : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_route_options)

        val intent = getIntent()
        val vehicle = intent.getStringExtra("Vehicle")

        val radioGroup = findViewById<RadioGroup>(R.id.radioGroup2)
        val selectOptionRoute = findViewById<Button>(R.id.buttonSelectOptionRoute)
        val optionSafe = findViewById<RadioButton>(R.id.buttonSafe)
        val optionFast = findViewById<RadioButton>(R.id.buttonFast)
        var check = false
        val time = LocalTime.now()
        var locationLongtitude = 0
        var locationLatitude = 0
        var routeOption = ""

        radioGroup.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if (rb != null)
                check = true
        }
        optionSafe.setOnClickListener {
            routeOption = "safe"
        }
        optionFast.setOnClickListener {
            routeOption = "fast"
        }
        selectOptionRoute.setOnClickListener {
            if (!check) {
                val toast1 = Toast.makeText(
                    applicationContext,
                    "Please activity_select_vehicle_interface.xml an option.",
                    Toast.LENGTH_LONG
                )
                toast1.setGravity(Gravity.CENTER, 0, 0)
                toast1.show()
            }
            else {
                val intent = Intent(this, routeOptions::class.java)
                intent.putExtra("Vehicle", vehicle)
                intent.putExtra("RouteOption", routeOption)
                startActivity(intent)
            }
        }
    }
}