package com.example.ermistest

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.RequiresApi
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val safetyReview = findViewById<EditText>(R.id.safetyReviewText)
        val uploadSafetyReview = findViewById<Button>(R.id.buttonUploadSafety)
        val goBack = findViewById<Button>(R.id.buttonReturn)
        uploadSafetyReview.setOnClickListener {
            //dispMessage.setText("The Safety Review has been uploaded")
            var safety = SafetyReview(placeId = "Cafe", username = "Ermis", reviewTime = LocalDate.now(), reviewText = safetyReview.text.toString())
            //safety.reviewText = safetyReview.text.toString()
            val toast1 = Toast.makeText(applicationContext, "The Safety Review has been uploaded"+safety.reviewTime, Toast.LENGTH_LONG)
            toast1.setGravity(Gravity.CENTER, 0,0)
            toast1.show()
        }
        goBack.setOnClickListener {
            val toast1 = Toast.makeText(applicationContext, "You are back", Toast.LENGTH_LONG)
            toast1.setGravity(Gravity.CENTER, 0,0)
            toast1.show()
        }
    }
}

open class Route {
    val startLongitute : Float? = null
    val startLatitude : Float? = null
    val destinationLongitute : Float? = null
    val destinationLatitude : Float? = null
    var routePoints : Array<Float>? = null
    enum class transportMeans
    {
        MMM,
        bikeOrByFoot,
        car
    }
    val startTime : Int? = null
    val endTime : Int? = null
    val MMMInfo : Int? = null

    fun calculateTimetable (startingTime: Int, routePoints: Array<Float>): Int
    {
        println("Timetable")
        var timetable = 10
        return timetable
    }
    fun MMMRoute (MMMInfo: String, startLatitude: Float, startLongitute: Float, destinationLatitude: Float, destinationLongitute: Float) :Array<Float>
    {
        println("MMMRoute")
        var route = arrayOf<Float>(12.2f)
        return route
    }
    fun concatenateRoute (routePoints1: Array<Float>, routePoints2: Array<Float>): Array<Float>
    {
        val route = routePoints1 + routePoints2
        println("concatenateRoute")
        return route
    }
    fun navigate (locationLatitude: Float, locationLongtitude: Float, destinationLongitute: Float, destinationLatitude: Float)
    {
        println("navigate")
    }
}
class SafeRoute : Route() {
    fun calculateSafeRoute (startLatitude: Float, startLongitute: Float, destinationLatitude: Float, destinationLongitute: Float, transportMeans: String): Array<Float>
    {
        val safeRoute = arrayOf<Float>(10.1f, 20.2f, 30.3f, 40.4f)
        println("route");
        return safeRoute;
    }
}
class FastRoute : Route() {
    fun calculateFastRoute (startLatitude: Float, startLongitute: Float, destinationLatitude: Float, destinationLongitute: Float, transportMeans: String): Array<Float>
    {
        val fastRoute = arrayOf<Float>(10.1f, 20.2f, 30.3f, 40.4f)
        println("route");
        return fastRoute;
    }
}
class SafetyReview(placeId: String, username: String, reviewText: String, reviewTime: LocalDate){
    var placeId : String? = null
    var username : String? = null
    var reviewText : String? = null
    var reviewTime : LocalDate? = null
    var staffGrade : Int? = null
    var equipmentGrade : Int? = null
    var overallGrade : Int? = null
    var upvoteCounter : Int = 0
    fun getMostUpvoted (location: String): Int {
        return 0
    }
    fun getAllReviews (location: String): Int {
        return 0
    }
    fun upvote (): Int {
        upvoteCounter+=upvoteCounter
        return upvoteCounter
    }
    fun downvote (): Int {
        upvoteCounter-=upvoteCounter
        return upvoteCounter
    }
    init {
        this.placeId = placeId
        this.username = username
        this.reviewTime = reviewTime
        this.reviewText = reviewText
        this.staffGrade = staffGrade
    }
}
