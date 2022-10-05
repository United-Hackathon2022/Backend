package com.hackaton.hackation2022.domain.feed.facade;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
public class FeedFacade {

    private final FeedRepository feedRepository;

    @Transactional(readOnly = true)
    public Feed findFeedById(Long id) {
        return feedRepository.findById(id)
                .orElseThrow(IllegalArgumentException::new);
    }
}
