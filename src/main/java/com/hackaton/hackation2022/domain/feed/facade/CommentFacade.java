package com.hackaton.hackation2022.domain.feed.facade;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepository;
import com.hackaton.hackation2022.domain.feed.exception.FeedNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CommentFacade {
    private final CommentRepository commentRepository;

    public Comment getCommentByFeedId(Long feedId) {
        return commentRepository.findAllByFeedId(feedId)
                .orElseThrow(() -> FeedNotFoundException.EXCEPTION);
    }
}
