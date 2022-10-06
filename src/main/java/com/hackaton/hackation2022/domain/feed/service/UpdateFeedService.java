package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.hackaton.hackation2022.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateFeedService {

    private final FeedFacade feedFacade;
    private final UserFacade userFacade;

    @Transactional
    public void execute(Long feedId, UpdateFeedRequest request) {
        Feed feed = feedFacade.getFeedById(feedId);
        feed.validateUser(userFacade.queryCurrentUser());

        feed.updateFeed(request.getTitle(), request.getContent(), request.getType());
    }
}
