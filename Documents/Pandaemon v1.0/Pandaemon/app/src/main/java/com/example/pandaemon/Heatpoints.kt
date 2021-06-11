package com.example.pandaemon

import com.google.firebase.Timestamp
import com.google.firebase.firestore.GeoPoint
import com.google.type.Date
import com.google.type.DateTime


class Heatpoints() {
    var latitude: Double = 0.0
    var longitude: Double = 0.0
    var location = GeoPoint(latitude, longitude)
    var Duration: Int = 0
    var timeRecorded = Timestamp(0, 0)

}
