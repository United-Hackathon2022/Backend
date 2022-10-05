package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class QueryFeedDetailService {

    private final FeedFacade feedFacade;

    public FeedDetailResponse execute(Long id) {
        return FeedDetailResponse.of(feedFacade.findFeedById(id));
    }
}
