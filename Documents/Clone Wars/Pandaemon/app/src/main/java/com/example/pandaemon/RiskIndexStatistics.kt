package com.example.pandaemon

import kotlin.math.pow
import kotlin.math.sqrt

class RiskIndexStatistics(val placesId:String, var _hasReviews: Boolean= false,
                          var _hasHeatpoints: Boolean= false, var _hasLivePop: Boolean= false,
                          var reviewsSufficient: Boolean=true,var noOfReviews: Int= 0,
                          var reviewAverage: Double= 0.0 ,var heatpointRating: Double= 0.0,
                          var livePopRating: Double=0.0){

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
    fun calculateRiskIndex(){
        if (!hasReviews) reviewAverage=0.0
        if (!hasHeatpoints) heatpointRating=0.0
        if (!hasLivePop) livePopRating=0.0
        if (noOfParameters!= 0)
            riskIndex= (reviewAverage+livePopRating+heatpointRating)/noOfParameters
        else println("You have chosen no parameters!")
        println("Risk Index is $riskIndex")
        println(noOfParameters)
        println(hasReviews)
        println(hasHeatpoints)
        println(hasLivePop)
        calculateHeatpointRating(14.558600, 38.008989)
    }
    fun calculateHeatpointRating(locationLatitude: Double, locationLongitude: Double){
        //NORMALLY SELECTS HEATPOINTS FROM THE DATABASE BY COMPARING POINT COORDINATES WITH USER'S
        //NO DATABASE FUNCTIONALITY CURRENTLY, SO here's a dummy heatpoint array
        // In gmaps geolocation coordinates (values from -100 to 100), a difference of 0.001 between
        //two latitudes denotes approximate 100 meters of distance. For a latitude of 37N (average
        // of Greece), a difference of 0.001 is instead roughly 75 meters of distance.
        // distance= sqrt( (locationLat-pointLat)^2 + (((locationLong-pointLong)*0.75)^2))
        var aggregatedDanger= 0.0    //danger of every relevant point aggregates here
        var distance: Double
        val heatpointList = MutableList(10) {
            listOf(14.556600, 38.009989, 4,1)  //latitude, longitude, duration in minutes, age in days
            listOf(14.556600, 38.009989, 4,2)
            listOf(14.556600, 38.009989, 4,3)
            listOf(14.556600, 38.009989, 4,4)
            listOf(14.556600, 38.009989, 4,7)
            listOf(14.556600, 38.009989, 4,14)
            listOf(14.556600, 38.009989, 4,1)
            listOf(14.556600, 38.009989, 4,1)
            listOf(14.556600, 38.009989, 4,1)
            listOf(14.556600, 38.009989, 4,1)

        }
        var repCounter=0
        heatpointList.forEach{
            var pointLatitude= heatpointList[repCounter][0] as Double
            var pointLongitude= heatpointList[repCounter][1] as Double
            var pointDuration= heatpointList[repCounter][2]
            var days= heatpointList[repCounter][3] as Int
            println("$pointLatitude")
            distance= sqrt((locationLongitude - pointLongitude).pow(2.0) +((locationLatitude - pointLatitude)*0.75).pow(2.0))
            println(distance)


            if (distance<0.005 && days<4) { //minimum requirements to consider something a threat, a distance of less than 500 meters, up to three days prior
               if (distance< 0.001){
                   aggregatedDanger+=3  //a case this close to the area, regardless of other parameters, always poses high risk
                   if (days<2) {
                       aggregatedDanger += 2
                   }
               }

            }
            repCounter++

        }

    }
}
