package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepository;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.CreateCommentRequest;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class CreateCommentService {

    private final UserFacade userFacade;
    private final FeedFacade feedFacade;
    private final CommentRepository commentRepository;

    @Transactional
    public void execute(CreateCommentRequest request, Long feedId) {
        User user = userFacade.queryCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        Comment comment = Comment.builder()
                .content(request.getContent())
                .feed(feed)
                .user(user)
                .build();

        commentRepository.save(comment);
    }
}
