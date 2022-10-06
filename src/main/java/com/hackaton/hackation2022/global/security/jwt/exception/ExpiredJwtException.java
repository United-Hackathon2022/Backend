package com.hackaton.hackation2022.global.security.jwt.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;
import com.hackaton.hackation2022.global.security.jwt.error.SecurityErrorProperty;

public class ExpiredJwtException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(SecurityErrorProperty.EXPIRED_JWT);
    }
}
