package com.hackaton.hackation2022.global.security.jwt.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;
import com.hackaton.hackation2022.global.security.jwt.error.SecurityErrorProperty;

public class CredentialsNotFoundException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new CredentialsNotFoundException();

    private CredentialsNotFoundException() {
        super(SecurityErrorProperty.CREDENTIALS_NOT_FOUND);
    }
}
