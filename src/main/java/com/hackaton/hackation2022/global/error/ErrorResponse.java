package com.hackaton.hackation2022.global.error;

import com.hackaton.hackation2022.global.error.exception.ErrorProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
public class ErrorResponse {

    private final int status;
    private final String message;

    @Builder
    public ErrorResponse(ErrorProperty property) {
        this.status = property.getStatus();
        this.message = property.getMessage();
    }
}
