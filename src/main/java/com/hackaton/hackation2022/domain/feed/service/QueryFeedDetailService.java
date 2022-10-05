package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedDetailResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class QueryFeedDetailService {

    private final FeedFacade feedFacade;

    @Transactional(readOnly = true)
    public FeedDetailResponse execute(Long feedId) {
        return FeedDetailResponse.of(feedFacade.findFeedById(feedId));
    }
}
