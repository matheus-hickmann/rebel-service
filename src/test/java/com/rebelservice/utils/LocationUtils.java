package com.rebelservice.utils;

import com.rebelservice.model.Location;

public class LocationUtils {

    public static Location createLocation() {
        return Location.builder()
                .latitude(2.00023232)
                .galaxyName("Testing is not so far far away...")
                .longitude(222.32313423414512341234)
                .build();
    }
}
