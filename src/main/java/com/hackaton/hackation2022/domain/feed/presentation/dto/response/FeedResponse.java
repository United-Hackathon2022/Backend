package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class FeedResponse {

    private String title;
    private String content;
    private UserResponse user;

    public static FeedResponse of(Feed feed) {
        return FeedResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .user(UserResponse.of(feed.getUser()))
                .build();
    }
}