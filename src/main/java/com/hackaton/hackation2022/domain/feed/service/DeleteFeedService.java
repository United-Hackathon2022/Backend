package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DeleteFeedService {

    private final FeedRepository feedRepository;
    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Long feedId) {
        Feed feed = feedFacade.getFeedById(feedId);
        // TODO :: getCurrentUser
        feed.validateUser(null);
        feedRepository.delete(feed);
    }
}
