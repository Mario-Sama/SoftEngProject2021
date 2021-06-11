package com.example.pandaemon

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.LocalDateTime

class ReviewActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    var db = Firebase.firestore

    private companion object {
        private const val TAG = "ReviewActivity"
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review)

        val safetyReview = findViewById<EditText>(R.id.safetyReviewText)
        val uploadSafetyReview = findViewById<Button>(R.id.buttonUploadSafety)
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
                    "overallGrade" to (rate * 2).toInt(),
                    "upvoteCounter" to 0,
                    "equipmentGrade" to -1,
                    "distanceGrade" to -1
                )
                val toast1 = Toast.makeText(
                    applicationContext,
                    "The Safety Review has been uploaded" + (rate * 2).toInt(),
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

                        val intent = Intent(this, MainActivity::class.java) //TODO : MOVE FROM MAIN TO MAP ACTIVITY
                        startActivity(intent)
                    }
            }
        }
    }
}