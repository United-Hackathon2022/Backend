package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.QueryFeedListResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.Writer;
import com.hackaton.hackation2022.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class QueryFeedListService {
    private final FeedRepository feedRepository;
    private final UserFacade userFacade;

    @Transactional(readOnly = true)
    public QueryFeedListResponse execute(FeedType type) {
        userFacade.queryCurrentUser();

        List<QueryFeedResponse> feedList = feedRepository.findAllByType(type)
                .stream()
                .map(feed -> QueryFeedResponse.builder()
                        .id(feed.getId())
                        .title(feed.getTitle())
                        .content(feed.getContent())
                        .type(feed.getType())
                        .user(Writer.builder()
                                .name(feed.getUser().getName())
                                .profileImageUrl(feed.getUser().getProfileImageUrl())
                                .build())
                        .build())
                .collect(Collectors.toList());

        return new QueryFeedListResponse(feedList);
    }
}
