package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FeedListResponse {

    private List<FeedResponse> feedList;
}
