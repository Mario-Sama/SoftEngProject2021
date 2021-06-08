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

class selectVehicleInterface : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_vehicle_interface)

        val radioGroup1 = findViewById<RadioGroup>(R.id.radioGroup1)
        val apply = findViewById<Button>(R.id.buttonApply)
        val bikeOrByfoot = findViewById<RadioButton>(R.id.buttonBikeOrByFoot)
        val car = findViewById<RadioButton>(R.id.buttonCar)
        val MMM = findViewById<RadioButton>(R.id.buttonMMM)
        var vehicle = ""
        var check2 = false
        var check1 = false

        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val optionSafe = findViewById<RadioButton>(R.id.buttonSafe)
        val optionFast = findViewById<RadioButton>(R.id.buttonFast)
        val time = LocalTime.now()
        var locationLongtitude = 0
        var locationLatitude = 0
        var routeOption = ""

        radioGroup1.setOnCheckedChangeListener { radioGroup, i ->
            var rb1 = findViewById<RadioButton>(i)
            if (rb1 != null)
                check1 = true
        }
        bikeOrByfoot.setOnClickListener {
            vehicle = "bikeOrByFoot"
        }
        car.setOnClickListener {
            vehicle = "car"
        }
        MMM.setOnClickListener {
            vehicle = "MMM"
        }
        apply.setOnClickListener {
            if (!check1 || !check2) {
                val toast1 = Toast.makeText(
                    applicationContext,
                    "Please fill the fields.",
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
            radioGroup2.setOnCheckedChangeListener { radioGroup, i ->
                var rb2 = findViewById<RadioButton>(i)
                if (rb2 != null)
                    check2 = true
            }
        }
        optionSafe.setOnClickListener {
            routeOption = "safe"
        }
        optionFast.setOnClickListener {
            routeOption = "fast"
        }
    }
}