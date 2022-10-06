package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class QueryFeedDetailResponse {
    private final String title;
    private final String content;
    private final FeedType type;
    private final Writer user;
    private final List<QueryCommentResponse> comments;
}
