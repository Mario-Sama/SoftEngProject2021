package com.example.pandaemon

import java.time.LocalTime

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

enum class transport {
    MMM,
    bikeOrByFoot,
    car,
    none
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
        println("route")
        return fastRoute
    }
}