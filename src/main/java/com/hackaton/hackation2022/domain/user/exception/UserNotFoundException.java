package com.hackaton.hackation2022.domain.user.exception;

import com.hackaton.hackation2022.domain.user.error.UserErrorProperty;
import com.hackaton.hackation2022.global.error.exception.DalgeoriException;

public class UserNotFoundException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new UserNotFoundException();

    private UserNotFoundException() {
        super(UserErrorProperty.USER_NOT_FOUND);
    }
}
