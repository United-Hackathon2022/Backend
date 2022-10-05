package com.hackaton.hackation2022.domain.feed.exception;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;

public class InvalidFeedTypeException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new InvalidFeedTypeException();

    private InvalidFeedTypeException() {
        super(FeedErrorProperty.INVALID_FEED_TYPE);
    }
}