package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.CommentResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedDetailService {

    private final FeedFacade feedFacade;

    @Transactional(readOnly = true)
    public FeedDetailResponse execute(Long feedId) {
        Feed feed = feedFacade.findFeedById(feedId);

        return FeedDetailResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .type(feed.getType())
                .user(createUserResponse(feed.getUser()))
                .comments(feed.getComments().stream()
                        .map(CommentResponse::of).collect(Collectors.toList()))
                .build();
    }

    private UserResponse createUserResponse(User user) {
        return UserResponse.builder()
                .name(user.getName())
                .profileImageUrl(user.getProfileImageUrl())
                .build();
    }
}
