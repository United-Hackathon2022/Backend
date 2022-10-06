package com.hackaton.hackation2022.domain.feed.facade;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class CommentFacade {
    private final CommentRepository commentRepository;

    public List<Comment> getCommentByFeedId(Long feedId) {
        return commentRepository.findAllByFeedId(feedId);
    }
}
