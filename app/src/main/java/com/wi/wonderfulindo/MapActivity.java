package com.wi.wonderfulindo;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;
    double lat = -7.607735;
    double lng = 110.204441;
    String name = "Borobudur";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.map);

        String latlng = getIntent().getStringExtra("latlong");
        if (latlng != null && !latlng.isEmpty()){
            String[] ll = latlng.split(",");
            lat = Double.parseDouble(ll[0]);
            lng = Double.parseDouble(ll[1]);
        }
        name = getIntent().getStringExtra("placeName");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;

        LatLng inputLatLong = new LatLng(lat, lng);
        map.addMarker(new MarkerOptions().position(inputLatLong).title(name));
        //map.moveCamera(CameraUpdateFactory.newLatLng(inputLatLong));
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(inputLatLong, 15.0f));


    }
}
