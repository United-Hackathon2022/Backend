package com.hackaton.hackation2022.global.security.jwt.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;
import com.hackaton.hackation2022.global.security.jwt.error.JwtErrorProperty;

public class ExpiredJwtException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new ExpiredJwtException();

    private ExpiredJwtException() {
        super(JwtErrorProperty.EXPIRED_JWT);
    }
}
