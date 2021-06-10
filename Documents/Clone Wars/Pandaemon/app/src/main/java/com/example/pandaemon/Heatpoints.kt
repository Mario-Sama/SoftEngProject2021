package com.example.pandaemon

import com.google.firebase.firestore.GeoPoint


class Heatpoints(){
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var location= GeoPoint(latitude, longitude)
    var pointDuration: Int = 0
    var timeRecorded: String=""
}
