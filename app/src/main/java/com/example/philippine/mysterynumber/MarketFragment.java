package com.example.philippine.mysterynumber;

import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MarketFragment extends Fragment implements OnMapReadyCallback {

    private GoogleMap mMap;
    private MainActivity mActivity;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        MapFragment mMapFragment = (MapFragment) getChildFragmentManager().findFragmentById(R.id.googleMap);
        mMapFragment.getMapAsync(this);


        return  view;
    }



    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mActivity = (MainActivity) context;
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng auchanLatLng = new LatLng(50.675335, 3.1374579);
        mMap.addMarker(new MarkerOptions().position(auchanLatLng).title("Siège Auchan"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(auchanLatLng));

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(auchanLatLng, 12.0f));

    }
}
