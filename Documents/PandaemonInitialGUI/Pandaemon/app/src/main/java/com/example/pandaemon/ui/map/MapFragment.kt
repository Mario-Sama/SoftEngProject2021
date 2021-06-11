package com.example.pandaemon.ui.map

import android.content.Context;
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pandaemon.R
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.config.Configuration.*
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.CustomZoomButtonsController
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.Marker
import org.osmdroid.views.overlay.compass.CompassOverlay


class MapFragment : Fragment() {
    private var map: MapView? = null
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_map, container, false)


        //map = MapView(inflater.getContext(), 256, getContext());
        map = root.findViewById(R.id.mapview)
        map?.setTileSource(TileSourceFactory.MAPNIK);
        map?.getController()?.setZoom(18.0);

        map?.getZoomController()?.setVisibility(CustomZoomButtonsController.Visibility.ALWAYS);
        map?.setMultiTouchControls(true);

        val point = GeoPoint(45.845557, 26.170010)
        val mapController = map?.controller
        mapController?.setZoom(9.5)
        val startPoint = GeoPoint(48.8583, 2.2944);
        mapController?.setCenter(startPoint);

        val startMarker = Marker(map)
        startMarker.setPosition(point)
        startMarker.setAnchor(Marker.ANCHOR_CENTER, Marker.ANCHOR_CENTER)
        map?.getOverlays()?.add(startMarker)

        map?.getController()?.setCenter(point)

        return root;
    }
}