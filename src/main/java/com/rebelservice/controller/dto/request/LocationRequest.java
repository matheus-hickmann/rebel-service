package com.rebelservice.controller.dto.request;

public record LocationRequest(
        Double latitude,
        Double longitude,
        String galaxyName
) {
}
