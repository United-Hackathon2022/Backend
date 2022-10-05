package com.hackaton.hackation2022.domain.feed.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;

public class NotAuthorizedFeedException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new NotAuthorizedFeedException();

    private NotAuthorizedFeedException() {
        super(FeedErrorProperty.NOT_AUTHORIZED_FEED);
    }
}