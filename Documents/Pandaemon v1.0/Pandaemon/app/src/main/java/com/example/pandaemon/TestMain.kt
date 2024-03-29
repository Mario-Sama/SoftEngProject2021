package com.example.pandaemon

import android.os.Build
import androidx.annotation.RequiresApi
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.GeoPoint
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase


@RequiresApi(Build.VERSION_CODES.O)
fun main() {
    val db= Firebase.firestore
   // val heatpoints = db.collection("heatpoints")
    val ri1= RiskIndexStatistics("scrap", _hasHeatpoints = true, noOfReviews = 7)
    ri1.hasReviews= true
    ri1.hasHeatpoints= false
    ri1.reviewAverage= 1.5
    ri1.heatpointRating= 6.0
    ri1.hasHeatpoints= true
    ri1.hasLivePop= true
    ri1.livePopRating= 9.1
    ri1.hasLivePop= false
    val param1= RiskIndexParameters(username = "Woop123", hasLivePop = false)
    param1.hasLivePop=true
    param1.hasReviews=false
    ri1.calculateRiskIndex()


  /*  val data1 = hashMapOf(
        "duration" to 15,
        "timeRecorded" to FieldValue.serverTimestamp(),
        "location" to GeoPoint(35.000,21.000),
    )
    heatpoints.document("heatpointuploadtest").set(data1) */

}