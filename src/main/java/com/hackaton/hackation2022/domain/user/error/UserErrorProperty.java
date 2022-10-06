package com.hackaton.hackation2022.domain.user.error;

import com.hackaton.hackation2022.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserErrorProperty implements ErrorProperty {

    USER_NOT_FOUND(404, "User Not Found");

    private final int status;
    private final String message;
}
