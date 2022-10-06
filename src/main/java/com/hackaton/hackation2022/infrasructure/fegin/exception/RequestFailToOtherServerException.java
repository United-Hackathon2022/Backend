package com.hackaton.hackation2022.infrasructure.fegin.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;
import com.hackaton.hackation2022.global.error.exception.ErrorCode;

public class RequestFailToOtherServerException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new RequestFailToOtherServerException();

    private RequestFailToOtherServerException() {
        super(ErrorCode.REQUEST_FAIL_TO_OTHER_SERVER);
    }

}
