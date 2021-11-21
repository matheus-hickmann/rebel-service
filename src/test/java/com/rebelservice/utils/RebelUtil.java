package com.rebelservice.utils;

import com.rebelservice.model.Gender;
import com.rebelservice.model.Location;
import com.rebelservice.model.Rebel;

import java.util.UUID;

public class RebelUtil {

    public static Rebel createRebel(UUID id) {
        return Rebel.builder()
                .id(id)
                .age(27)
                .gender(Gender.OTHER)
                .location(LocationUtils.createLocation())
                .build();
    }
}
