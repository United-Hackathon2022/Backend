package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class QueryFeedListResponse {
    private final List<QueryFeedResponse> feedList;
}
