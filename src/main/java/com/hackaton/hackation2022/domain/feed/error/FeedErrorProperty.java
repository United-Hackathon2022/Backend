package com.hackaton.hackation2022.domain.feed.error;

import com.hackaton.hackation2022.global.error.exception.ErrorProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FeedErrorProperty implements ErrorProperty {

    FEED_NOT_FOUND(404, "Feed Not Found");

    private final int status;
    private final String message;
}
