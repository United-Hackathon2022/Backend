package com.hackaton.hackation2022.global.security.jwt.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;
import com.hackaton.hackation2022.global.security.jwt.error.SecurityErrorProperty;

public class InvalidJwtException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new InvalidJwtException();

    private InvalidJwtException() {
        super(SecurityErrorProperty.EXPIRED_JWT);
    }
}
