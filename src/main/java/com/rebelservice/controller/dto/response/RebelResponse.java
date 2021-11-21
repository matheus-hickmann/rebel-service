package com.rebelservice.controller.dto.response;

import com.rebelservice.controller.dto.request.LocationRequest;
import com.rebelservice.model.Gender;

import java.util.UUID;

public record RebelResponse(
        UUID id,
        String name,
        Integer age,
        Gender gender,
        LocationRequest location
) {
}
