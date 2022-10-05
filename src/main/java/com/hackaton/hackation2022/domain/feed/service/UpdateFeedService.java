package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.FeedRequest;
import com.hackaton.hackation2022.domain.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UpdateFeedService {

    private final FeedFacade feedFacade;

    @Transactional
    public void execute(Long id, FeedRequest request) {
        Feed feed = feedFacade.findFeedById(id);
        // TODO :: getCurrentUser
        validateUser(feed.getUser(), null);

        feed.updateFeed(request.getTitle(), request.getContent(), request.getType());
    }

    private void validateUser(User expected, User actual) {
        if (expected.getId() != actual.getId()) {
            throw new RuntimeException("");
        }
    }
}
