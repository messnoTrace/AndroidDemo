package com.notrace.otto;


/**
 * Created by notrace on 2016/3/24.
 */
public class LocationChangeEvent {
    public final  float lat;
    public final float lon;
    public LocationChangeEvent(float lat,float lon)
    {
        this.lat=lat;
        this.lon=lon;

    }
    @Override
    public String toString() {

        return new StringBuilder("(")
                .append(lat)
                .append(",")
                .append(lon)
                .append(")")
                .toString();
    }
}
