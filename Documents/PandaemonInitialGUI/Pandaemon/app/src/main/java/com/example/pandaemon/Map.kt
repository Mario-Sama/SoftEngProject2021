package com.example.pandaemon

import android.os.Bundle
import android.preference.PreferenceManager

import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

import org.osmdroid.config.Configuration.*
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker

import java.util.ArrayList

class Map : AppCompatActivity() {
    private val REQUEST_PERMISSIONS_REQUEST_CODE = 1;
    private lateinit var map : MapView;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);

        getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));

        setContentView(R.layout.map_layout);

        map = findViewById<MapView>(R.id.mapview)
        map.setTileSource(TileSourceFactory.MAPNIK);
        val mapController = map.controller
        mapController.setZoom(18.0)
        val startPoint = GeoPoint(38.246639, 21.734573);
        mapController.setCenter(startPoint);
        val startMarker = Marker(map)
        startMarker.setPosition(startPoint)
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
        map?.getOverlays()?.add(startMarker)
        startMarker.title = "38.246639, 21.734573"
    }

    override fun onResume() {
        super.onResume();
        map.onResume();
    }

    override fun onPause() {
        super.onPause();
        map.onPause();
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        val permissionsToRequest = ArrayList<String>();
        var i = 0;
        while (i < grantResults.size) {
            permissionsToRequest.add(permissions[i]);
            i++;
        }
        if (permissionsToRequest.size > 0) {
            ActivityCompat.requestPermissions(
                this,
                permissionsToRequest.toTypedArray(),
                REQUEST_PERMISSIONS_REQUEST_CODE);
        }
    }
}