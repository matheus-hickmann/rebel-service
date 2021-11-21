package com.rebelservice.model;

import com.rebelservice.controller.dto.request.LocationRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Location {

    private Double latitude;
    private Double longitude;
    private String galaxyName;

    public static Location fromRequest(LocationRequest request) {
        return Location.builder()
                .galaxyName(request.galaxyName())
                .latitude(request.latitude())
                .longitude(request.longitude())
                .build();
    }

}