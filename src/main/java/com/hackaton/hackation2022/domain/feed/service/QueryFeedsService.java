package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.feed.exception.InvalidFeedTypeException;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedsService {

    private final FeedRepository feedRepository;

    public List<FeedResponse> execute(String type) {
        if (type.equals("question")) {
            return feedRepository.findFeedsByType(FeedType.QUESTION)
                    .stream().map(FeedResponse::of).collect(Collectors.toList());
        } else if (type.equals("job-offer")) {
            return feedRepository.findFeedsByType(FeedType.JOB_OFFER)
                    .stream().map(FeedResponse::of).collect(Collectors.toList());
        } else {
            throw InvalidFeedTypeException.EXCEPTION;
        }
    }
}
