package com.example.pandaemon

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

    }

}






