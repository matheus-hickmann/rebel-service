package com.rebelservice.errors.exceptions;

import com.rebelservice.errors.ErrorCode;
import com.rebelservice.errors.KnownException;
import org.springframework.http.HttpStatus;

public class RebelNotFoundException extends KnownException {

    public RebelNotFoundException() {
        super(ErrorCode.REBEL_NOT_FOUND, HttpStatus.NOT_FOUND);
    }
}
