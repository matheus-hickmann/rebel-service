package com.rebelservice.errors;

public record ErrorRecord(
        ErrorCode code,
        String description
) {
}
