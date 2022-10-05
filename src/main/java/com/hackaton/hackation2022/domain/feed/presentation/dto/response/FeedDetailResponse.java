package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
public class FeedDetailResponse {

    private String title;
    private String content;
    private FeedType type;
    private UserResponse user;
    private List<CommentResponse> comments;

    public static FeedDetailResponse of(Feed feed) {
        return FeedDetailResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .type(feed.getType())
                .user(UserResponse.of(feed.getUser()))
                .comments(feed.getComments().stream()
                        .map(CommentResponse::of).collect(Collectors.toList()))
                .build();
    }
}
