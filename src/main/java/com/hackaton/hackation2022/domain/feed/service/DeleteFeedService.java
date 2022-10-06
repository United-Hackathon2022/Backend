package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepository;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepositoryCustom;
import com.hackaton.hackation2022.domain.feed.domain.repository.FeedRepository;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DeleteFeedService {

    private final FeedRepository feedRepository;
    private final FeedFacade feedFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(Long feedId) {
        Feed feed = feedFacade.getFeedById(feedId);
        // TODO :: getCurrentUser
        feed.validateUser(null);

        commentRepository.deleteCommentsByFeed(feed);
        feedRepository.delete(feed);
    }
}
