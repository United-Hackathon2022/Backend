package com.hackaton.hackation2022.domain.user.service;

import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.facade.UserFacade;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.QueryMyPageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class QueryMyPageService {
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryMyPageResponse execute() {
        User user = userFacade.queryCurrentUser();

        return QueryMyPageResponse.builder()
                .name(user.getName())
                .authCode(user.getAuthCode())
                .profileImageUrl(user.getProfileImageUrl())
                .followerCount(user.getFollowerCount())
                .followingCount(user.getFollowingCount())
                .build();
    }
}
