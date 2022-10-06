package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedListResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedResponse;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedListService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedListResponse execute(String type) {
        List<FeedResponse> feedList = feedRepository.findFeedsByType(FeedType.valueOf(type))
                .stream().map(this::createFeedResponse).collect(Collectors.toList());

        return FeedListResponse.builder()
                .feedList(feedList)
                .build();
    }

    private FeedResponse createFeedResponse(Feed feed) {
        return FeedResponse.builder()
                .id(feed.getId())
                .title(feed.getTitle())
                .content(feed.getContent())
                .user(createUserResponse(feed.getUser()))
                .build();
    }

    private UserResponse createUserResponse(User user) {
        return new UserResponse(user.getName(), user.getProfileImageUrl());
    }
}
