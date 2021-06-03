package com.example.pandaemon


fun main() {
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

}