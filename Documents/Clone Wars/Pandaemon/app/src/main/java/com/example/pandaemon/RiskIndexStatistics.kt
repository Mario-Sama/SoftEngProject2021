package com.example.pandaemon

import android.content.ContentValues.TAG
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.time.Instant
import java.time.temporal.ChronoUnit
import kotlin.math.min
import kotlin.math.pow
import kotlin.math.sqrt

class RiskIndexStatistics(val placesId:String, var _hasReviews: Boolean= false,
                          var _hasHeatpoints: Boolean= false, var _hasLivePop: Boolean= false,
                          var reviewsSufficient: Boolean=true,var noOfReviews: Int= 0,
                          var reviewAverage: Double= 0.0 ,var heatpointRating: Double= 0.0,
                          var livePopRating: Double=0.0){

    val db = Firebase.firestore
    var riskIndex= 0.0
    var noOfParameters= 0
    var hasReviews: Boolean= _hasReviews
        set(value) {
            field=value
            noOfParameters=0
            if (hasHeatpoints) noOfParameters++
            if (hasReviews && reviewsSufficient) noOfParameters++
            if (hasLivePop) noOfParameters++
        }
    var hasHeatpoints: Boolean= _hasHeatpoints
        set(value) {
            field=value
            noOfParameters=0
            if (hasHeatpoints) noOfParameters++
            if (hasReviews && reviewsSufficient) noOfParameters++
            if (hasLivePop) noOfParameters++
        }
    var hasLivePop: Boolean= _hasLivePop
        set(value) {
            field=value
            noOfParameters=0
            if (hasHeatpoints) noOfParameters++
            if (hasReviews && reviewsSufficient) noOfParameters++
            if (hasLivePop) noOfParameters++
        }
    init {
        if (hasHeatpoints) noOfParameters++
        if (hasReviews && reviewsSufficient) noOfParameters++
        if (hasLivePop) noOfParameters++
    }
    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateRiskIndex(){
        if (!hasReviews) reviewAverage=0.0
        if (!hasHeatpoints) heatpointRating=0.0
        else if (hasHeatpoints) heatpointRating= calculateHeatpointRating(38.246275, 21.735079)
        if (!hasLivePop) livePopRating=0.0
        if (noOfParameters!= 0)
            riskIndex= (reviewAverage+livePopRating+heatpointRating)/noOfParameters
        else println("You have chosen no parameters!")
        println("Risk Index is $riskIndex")
        println(noOfParameters)
        println(hasReviews)
        println(hasHeatpoints)
        println(hasLivePop)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun calculateHeatpointRating(locationLatitude: Double, locationLongitude: Double): Double {
        //NORMALLY SELECTS HEATPOINTS FROM THE DATABASE BY COMPARING POINT COORDINATES WITH USER'S
        //NO DATABASE FUNCTIONALITY CURRENTLY, SO here's a dummy heatpoint array
        // In gmaps geolocation coordinates (values from -100 to 100), a difference of 0.001 between
        //two latitudes denotes approximate 100 meters of distance. For a latitude of 37N (average
        // of Greece), a difference of 0.001 is instead roughly 75 meters of distance.
        // distance= sqrt( (locationLat-pointLat)^2 + (((locationLong-pointLong)*0.75)^2))
        var aggregatedDanger = 0.0 //danger of every relevant point aggregates here
        var distance: Double
        var querycompleted= false
        db.collection("heatpoints")
            //.whereLessThanOrEqualTo("location.latitude", locationLatitude+ 0.005)
            //.whereGreaterThanOrEqualTo("location.latitude", locationLatitude- 0.005)
            .get()
            .addOnSuccessListener { documents ->
                for (document in documents) {
                    Log.d(TAG, "${document.id} => ${document.data}")
                    var heatpoint1 = document.toObject(Heatpoints::class.java)
                    println("HEATPOINT LOCATION IS " + heatpoint1.location)
                    val distance = sqrt(
                        (locationLatitude - heatpoint1.location.latitude).pow(2.0)
                                + ((locationLongitude - heatpoint1.location.longitude) * 0.75).pow(
                            2.0
                        )
                    )
                    println(distance)
                    var threeDaysAgo = Instant.now().minus(3, ChronoUnit.DAYS)
                    var seconds = threeDaysAgo.epochSecond
                    var nanos = threeDaysAgo.nano
                    var secondstamp = com.google.firebase.Timestamp(seconds, nanos)
                    if (distance < 0.005) {
                        aggregatedDanger++
                        println(aggregatedDanger)
                    }
                }
               querycompleted= true
            }
            //&& heatpoint1.Duration>0 && heatpoint1.timeRecorded.compareTo(secondstamp)>0
            .addOnFailureListener { exception ->
                Log.w(TAG, "Error getting documents: ", exception)
            }

        if (querycompleted) {return min(10.0, aggregatedDanger)}
        return min(10.0, aggregatedDanger)
    }
}
