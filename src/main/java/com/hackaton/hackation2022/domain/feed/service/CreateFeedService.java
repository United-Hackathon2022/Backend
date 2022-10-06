package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateFeedService {

    private final FeedRepository feedRepository;

    private final UserFacade userFacade;

    @Transactional
    public void execute(CreateFeedRequest request) {
        User user = userFacade.queryCurrentUser();
        Feed feed = Feed.builder()
                .title(request.getTitle())
                .content(request.getContent())
                .type(request.getType())
                .user(user)
                .build();

        feedRepository.save(feed);
    }
}
