package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryCommentResponse {
    private final String content;
    private final Writer user;
}
