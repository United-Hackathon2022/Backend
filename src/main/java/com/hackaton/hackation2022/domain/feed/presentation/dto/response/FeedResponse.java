package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedResponse {

    private String title;
    private String content;
    private FeedType type;

    public static FeedResponse of(Feed feed) {
        return FeedResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .type(feed.getType())
                .build();
    }
}
