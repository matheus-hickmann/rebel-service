package com.rebelservice.errors;

import lombok.Getter;

@Getter
public enum ErrorCode {
    UNKNOWN_EXCEPTION("Unexpected error"),
    REBEL_NOT_FOUND("Rebel not found")
    ;

    private final String description;

    ErrorCode(String description) {
        this.description = description;
    }

}
