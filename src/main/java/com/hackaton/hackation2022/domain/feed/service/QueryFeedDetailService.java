package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepository;
import com.hackaton.hackation2022.domain.feed.facade.CommentFacade;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.QueryCommentResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.QueryFeedDetailResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.QueryFeedResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.Writer;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.facade.UserFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class QueryFeedDetailService {
    private final UserFacade userFacade;
    private final CommentFacade commentFacade;
    private final CommentRepository commentRepository;
    private final FeedFacade feedFacade;

    @Transactional(readOnly = true)
    public QueryFeedDetailResponse execute(Long feedId) {
        userFacade.queryCurrentUser();
        Feed feed = feedFacade.getFeedById(feedId);

        List<QueryCommentResponse> commentList = commentRepository.findAllByFeedId(feedId)
                .stream()
                .map(comment1 -> QueryCommentResponse.builder()
                        .content(comment1.getContent())
                        .user(Writer.builder()
                                .name(comment1.getUser().getName())
                                .profileImageUrl(comment1.getUser().getProfileImageUrl())
                                .build())
                        .build()
                ).collect(Collectors.toList());

        return QueryFeedDetailResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .type(feed.getType())
                .user(Writer.builder()
                        .name(feed.getUser().getName())
                        .profileImageUrl(feed.getUser().getProfileImageUrl())
                        .build())
                .comments(commentList)
                .build();
    }
}
