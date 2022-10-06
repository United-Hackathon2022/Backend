package com.hackaton.hackation2022.domain.user.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class QueryMyPageResponse {
    private final String name;
    private final String authCode;
    private final String profileImageUrl;
    private final Integer followingCount;
    private final Integer followerCount;
}
