package com.hackaton.hackation2022.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode implements ErrorProperty {
    INTERNAL_SERVER_ERROR(500, "Internal Server Error"),
    REQUEST_FAIL_TO_OTHER_SERVER(400,  "Request fail to other server.");

    private final int status;
    private final String message;
}
