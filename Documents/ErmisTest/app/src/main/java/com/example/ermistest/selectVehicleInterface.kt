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
        val mmm = findViewById<RadioButton>(R.id.buttonMMM)
        var vehicle = MainActivity.transport.none
        var check2 = false
        var check1 = false

        val radioGroup2 = findViewById<RadioGroup>(R.id.radioGroup2)
        val optionSafe = findViewById<RadioButton>(R.id.buttonSafe)
        val optionFast = findViewById<RadioButton>(R.id.buttonFast)
        val startTime = LocalTime.now()
        val destinationTime = LocalTime.now()
        var locationLongitude : Float = 0f
        var locationLatitude : Float = 0f
        var destinationLatitude : Float = 1f
        var destinationLongitude : Float = 1f
        var routeOption = ""

        radioGroup1.setOnCheckedChangeListener { radioGroup, i ->
            var rb1 = findViewById<RadioButton>(i)
            if (rb1 != null)
                check1 = true
        }
        bikeOrByfoot.setOnClickListener {
            vehicle = MainActivity.transport.bikeOrByFoot
        }
        car.setOnClickListener {
            vehicle = MainActivity.transport.car
        }
        mmm.setOnClickListener {
            vehicle = MainActivity.transport.MMM
        }
        radioGroup2.setOnCheckedChangeListener { radioGroup, i ->
            var rb2 = findViewById<RadioButton>(i)
            if (rb2 != null)
                check2 = true
        }
        optionSafe.setOnClickListener {
            routeOption = "safe"
        }
        optionFast.setOnClickListener {
            routeOption = "fast"
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
                if (vehicle == MainActivity.transport.MMM) {
                    val toast1 = Toast.makeText(
                        applicationContext,
                        "!!!!!!!!!!!!!.",
                        Toast.LENGTH_LONG
                    )
                    toast1.setGravity(Gravity.CENTER, 0, 0)
                    toast1.show()
                    val intent = Intent(this, routeOptions::class.java)
                    intent.putExtra("RouteOption", routeOption)
                    startActivity(intent)
                }

                else {
                    val intent = Intent(this, selectVehicleInterface::class.java)
                    if (vehicle == MainActivity.transport.bikeOrByFoot) {
                        if (routeOption == "safe") {
                            var route = MainActivity.SafeRoute()
                            route.startLongitute = locationLongitude
                            route.startLatitude = locationLatitude
                            route.destinationLongitute = destinationLatitude
                            route.destinationLatitude = destinationLongitude
                            route.transportMeans = MainActivity.transport.bikeOrByFoot
                            route.startTime = startTime
                            route.endTime = destinationTime
                            route.MMMInfo = ""
                            val toast1 = Toast.makeText(
                                applicationContext,
                                "safe and bike."+route.startLatitude,
                                Toast.LENGTH_LONG
                            )
                            toast1.setGravity(Gravity.CENTER, 0, 0)
                            toast1.show()
                        } else if (routeOption == "fast") {
                            var route = MainActivity.FastRoute()
                            route.startLongitute = locationLongitude
                            route.startLatitude = locationLatitude
                            route.destinationLongitute = destinationLatitude
                            route.destinationLatitude = destinationLongitude
                            route.transportMeans = MainActivity.transport.bikeOrByFoot
                            route.startTime = startTime
                            route.endTime = destinationTime
                            route.MMMInfo = ""
                            val toast1 = Toast.makeText(
                                applicationContext,
                                "fast and bike.",
                                Toast.LENGTH_LONG
                            )
                            toast1.setGravity(Gravity.CENTER, 0, 0)
                            toast1.show()
                        } else {
                            val toast1 = Toast.makeText(
                                applicationContext,
                                "Something went wrong.",
                                Toast.LENGTH_LONG
                            )
                            toast1.setGravity(Gravity.CENTER, 0, 0)
                            toast1.show()
                        }
                    } else if (vehicle == MainActivity.transport.car) {
                        var route = MainActivity.FastRoute()
                        route.startLongitute = locationLongitude
                        route.startLatitude = locationLatitude
                        route.destinationLongitute = destinationLatitude
                        route.destinationLatitude = destinationLongitude
                        route.transportMeans = MainActivity.transport.car
                        route.startTime = startTime
                        route.endTime = destinationTime
                        route.MMMInfo = ""
                        val toast1 = Toast.makeText(
                            applicationContext,
                            "fast and car.",
                            Toast.LENGTH_LONG
                        )
                        toast1.setGravity(Gravity.CENTER, 0, 0)
                        toast1.show()
                    }
                    startActivity(intent)
                }
            }
        }
    }
}