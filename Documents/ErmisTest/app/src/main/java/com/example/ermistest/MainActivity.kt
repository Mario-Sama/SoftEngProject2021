package com.example.ermistest

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.tabs.TabLayout
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

 class MainActivity : AppCompatActivity() {
     @RequiresApi(Build.VERSION_CODES.O)
     var db = Firebase.firestore

     private companion object {
         private const val TAG = "MainActivity"
     }

     @RequiresApi(Build.VERSION_CODES.O)
     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val safetyReview = findViewById<EditText>(R.id.safetyReviewText)
         val uploadSafetyReview = findViewById<Button>(R.id.buttonUploadSafety)
         val goNav = findViewById<Button>(R.id.buttonNavigation)
         var rating = findViewById<RatingBar>(R.id.ratingBar)
         var username = "Ermis"
         rating.rating = 2.5f
         var ratingChange = false
         var rate = -1f

         rating.setOnRatingBarChangeListener { ratingBar, rat, fromUser ->
             rate = rating.rating
             ratingChange = true
         }
         uploadSafetyReview.setOnClickListener {
             val pattern = Regex(pattern = "@")
             val result = pattern.containsMatchIn(safetyReview.text.toString())
             if (result) {
                 val toast1 = Toast.makeText(
                     applicationContext,
                     "The Safety Review contains bad language. Please write politely!!!",
                     Toast.LENGTH_LONG
                 )
                 toast1.setGravity(Gravity.CENTER, 0, 0)
                 toast1.show()
             } else if (username != "Ermis") {
                 val toast1 = Toast.makeText(
                     applicationContext,
                     "You don't have permission to write safety review because you haven't been to that place before.",
                     Toast.LENGTH_LONG
                 )
                 toast1.setGravity(Gravity.CENTER, 0, 0)
                 toast1.show()
             } else {
                 val safety = db.collection("safety reviews")
                 val data = hashMapOf(
                     "placeId" to "Cafe",
                     "username" to "Ermis",
                     "reviewTime" to LocalDateTime.now(),
                     "reviewText" to safetyReview.text.toString(),
                     "staffGrade" to -1,
                     "overallGrade" to (rate*2).toInt(),
                     "upvoteCounter" to 0,
                     "equipmentGrade" to -1,
                     "distanceGrade" to -1
                 )
                 val toast1 = Toast.makeText(
                     applicationContext,
                     "The Safety Review has been uploaded"+(rate*2).toInt(),
                     Toast.LENGTH_LONG
                 )
                 toast1.setGravity(Gravity.CENTER, 0, 0)
                 toast1.show()
                 db.collection("safety reviews")
                     .add(data)
                     .addOnSuccessListener { documentReference ->
                         Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                     }
                     .addOnFailureListener { e ->
                         Log.w(TAG, "Error adding document", e)

                         val intent = Intent(this, MainActivity::class.java)
                         startActivity(intent)
                     }
             }
             goNav.setOnClickListener {
                 val intent = Intent(this, searchLocation::class.java)
                 startActivity(intent)
             }
         }
     }

     enum class transport {
         MMM,
         bikeOrByFoot,
         car,
         none
     }

     open abstract class Route() {
         var startLongitute: Float? = null
         var startLatitude: Float? = null
         var destinationLongitute: Float? = null
         var destinationLatitude: Float? = null
         var routePoints: Array<Float>? = null
         var transportMeans: Enum<transport>? = null
         var startTime: LocalTime? = null
         var endTime: LocalTime? = null
         var MMMInfo: String? = null

         fun calculateTimetable(startingTime: Int, routePoints: Array<Float>): Int {
             println("Timetable")
             var timetable = 10
             return timetable
         }

         fun MMMRoute(
             MMMInfo: String,
             startLatitude: Float,
             startLongitute: Float,
             destinationLatitude: Float,
             destinationLongitute: Float
         ): Array<Float> {
             println("MMMRoute")
             var route = arrayOf<Float>(12.2f)
             return route
         }

         fun concatenateRoute(
             routePoints1: Array<Float>,
             routePoints2: Array<Float>
         ): Array<Float> {
             val route = routePoints1 + routePoints2
             println("concatenateRoute")
             return route
         }

         fun navigate(
             locationLatitude: Float,
             locationLongtitude: Float,
             destinationLongitute: Float,
             destinationLatitude: Float
         ) {
             println("navigate")
         }
     }

     class SafeRoute() : Route() {
         fun calculateSafeRoute(
             startLatitude: Float,
             startLongitute: Float,
             destinationLatitude: Float,
             destinationLongitute: Float,
             transportMeans: String
         ): Array<Float> {
             val safeRoute = arrayOf<Float>(10.1f, 20.2f, 30.3f, 40.4f)
             println("route");
             return safeRoute;
         }
     }

     class FastRoute() : Route() {
         fun calculateFastRoute(
             startLatitude: Float,
             startLongitute: Float,
             destinationLatitude: Float,
             destinationLongitute: Float,
             transportMeans: String
         ): Array<Float> {
             val fastRoute = arrayOf<Float>(10.1f, 20.2f, 30.3f, 40.4f)
             println("route");
             return fastRoute;
         }
     }

     class SafetyReview(
         var placeId: String,
         var username: String,
         var reviewText: String,
         var reviewTime: LocalDateTime,
         var staffGrade: Int,
         var overallGrade: Float,
         var upvoteCounter: Int,
         var equipmentGrade: Int,
         var distanceGrade: Int
     ) {
         fun getMostUpvoted(location: String): Int {
             return 0
         }

         fun getAllReviews(location: String): Int {
             return 0
         }

         fun upvote(): Int {
             upvoteCounter += upvoteCounter
             return upvoteCounter
         }

         fun downvote(): Int {
             upvoteCounter -= upvoteCounter
             return upvoteCounter
         }
     }
 }
