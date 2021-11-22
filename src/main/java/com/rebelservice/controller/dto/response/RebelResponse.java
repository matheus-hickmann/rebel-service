package com.rebelservice.controller.dto.response;

import com.rebelservice.controller.dto.request.LocationRequest;
import com.rebelservice.model.Gender;
import com.rebelservice.model.Rebel;

import java.util.UUID;

public record RebelResponse(
        UUID id,
        String name,
        Integer age,
        Gender gender,
        LocationResponse location
) {

    public static RebelResponse fromEntity(Rebel rebel) {
        return new RebelResponse(
                rebel.getId(),
                rebel.getName(),
                rebel.getAge(),
                rebel.getGender(),
                LocationResponse.fromEntity(rebel.getLocation())
        );
    }
}
