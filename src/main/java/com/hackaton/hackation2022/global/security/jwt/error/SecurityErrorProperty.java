package com.hackaton.hackation2022.global.security.jwt.error;

import com.hackaton.hackation2022.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum SecurityErrorProperty implements ErrorProperty {

    EXPIRED_JWT(401, "Expired Jwt"),
    INVALID_JWT(401, "Invalid Jwt"),
    CREDENTIALS_NOT_FOUND(404, "Credentials Not Found");

    private final int status;
    private final String message;
}
