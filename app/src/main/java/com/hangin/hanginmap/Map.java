package com.hangin.hanginmap;

import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import java.util.ArrayList;

/**
 * Map class
 * Created by egehatirnaz on 30/04/2017.
 */

public class Map {
    //properties
    private ArrayList<LatLngBounds> areas;
    //ArrayList<Cards> cards;
    private LatLng myLocation;

    private LatLngBounds MAINCAMPUS;
    private LatLngBounds BILKENTCENTER;
    private LatLngBounds EASTCAMPUS;


    //constructors
    Map(){
        BILKENTCENTER = new LatLngBounds(new LatLng(39.880131, 32.747420), new LatLng(39.886003, 32.764185));
        MAINCAMPUS = new LatLngBounds(new LatLng(39.863761, 32.742553), new LatLng(39.876698 , 32.755793));
        EASTCAMPUS = new LatLngBounds(new LatLng(39.863418, 32.760566), new LatLng(39.879586, 32.766553));

        areas = new ArrayList<LatLngBounds>();
        areas.add(MAINCAMPUS);
        areas.add(EASTCAMPUS);
        areas.add(BILKENTCENTER);
    }

    //methods

    /**
     * addArea method
     * adds LatLngBounds to areas array.
     * @param area : desired LatLngBounds to act as sector
     */
    public void addArea(LatLngBounds area){
        areas.add(area);
    }

    /**
     * getMyLocation method
     * @return myLocation
     */
    public LatLng getMyLocation() {
        return myLocation;
    }

    /**
     * setMyLocation method
     * @param myLocation : user location
     */
    public void setMyLocation(LatLng myLocation) {
        this.myLocation = myLocation;
    }

    /**
     public void addCard(Card x){
     cards.add(x);
     }
     */
}
