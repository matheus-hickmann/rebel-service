package com.rebelservice.controller.dto.request;

import com.rebelservice.model.Gender;

public record RebelRequest(
        String name,
        Integer age,
        Gender gender,
        LocationRequest location) {
}
