package com.hackaton.hackation2022.domain.feed.exception;

import com.hackaton.hackation2022.domain.feed.error.FeedErrorProperty;
import com.hackaton.hackation2022.global.error.exception.DalgeoriException;

public class FeedNotFoundException extends DalgeoriException {

    public static final DalgeoriException EXCEPTION =
            new FeedNotFoundException();

    private FeedNotFoundException() {
        super(FeedErrorProperty.FEED_NOT_FOUND);
    }
}
