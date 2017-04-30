package com.hangin.hanginmap;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Run this activity with an emulator or with any android phone you like.
 * Best regards,
 * -Ege "Aegis" Hatirnaz
 */
public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        // Add a marker and move the camera
        LatLng bilkentB = new LatLng(39.869046, 32.747883);
        //mMap.addMarker(new MarkerOptions().position(bilkentB).title("Bilkent B Binası burada!"));
        //mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bilkentB, 20));
        //should be a property but imma test this shit.
        LatLngBounds MERKEZ = new LatLngBounds(new LatLng(39.863761, 32.742553), new LatLng(39.876698 , 32.755793));
        mMap.setLatLngBoundsForCameraTarget(MERKEZ);
        showSector(MERKEZ);
        findBuilding(bilkentB);
    }

    /**
     * Shows the building in map
     * Adds a marker on the coordinates of given building
     * And says "Here!"
     * @param building : given building's LatLng data
     */
    public void findBuilding(LatLng building){
        mMap.addMarker(new MarkerOptions().position(building).title("Here!"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(building, 18));
    }

    public void showSector(LatLngBounds SECTOR){
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(SECTOR.getCenter(), 17));
    }
}
