package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedListResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryQuestionFeedListService {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public FeedListResponse execute() {
        List<FeedResponse> feedList = feedRepository.findFeedsByType(FeedType.QUESTION)
                .stream().map(FeedResponse::of).collect(Collectors.toList());

        return FeedListResponse.builder()
                .feedList(feedList)
                .build();
    }
}
