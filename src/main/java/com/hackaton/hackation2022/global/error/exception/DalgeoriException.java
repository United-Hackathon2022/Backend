package com.hackaton.hackation2022.global.error.exception;

import lombok.Getter;

@Getter
public class DalgeoriException extends RuntimeException {

    private final ErrorCode errorCode;
    private final String message;

    public DalgeoriException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
        this.message = errorCode.getMessage();
    }

    public DalgeoriException(ErrorCode errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
        this.message = message;
    }
}
