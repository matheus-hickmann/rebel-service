package com.rebelservice.controller.dto.response;

import com.rebelservice.model.Location;

public record LocationResponse(
        Double latitude,
        Double longitude,
        String galaxyName
) {
    public static LocationResponse fromEntity(Location location) {
        return new LocationResponse(
                location.getLatitude(),
                location.getLongitude(),
                location.getGalaxyName()
        );
    }
}
