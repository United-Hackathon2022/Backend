package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryFeedResponse {
    private final Long id;
    private final String title;
    private final String content;
    private final FeedType type;
    private final Writer user;
}
