package com.hackaton.hackation2022.domain.feed.exception;

import com.hackaton.hackation2022.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeedErrorProperty implements ErrorProperty {

    INVALID_FEED_TYPE(400, "Invalid Feed Type"),
    ;

    private final int status;
    private final String message;
}