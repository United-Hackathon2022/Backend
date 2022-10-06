package com.hackaton.hackation2022.domain.feed.service;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.repository.CommentRepository;
import com.hackaton.hackation2022.domain.feed.domain.repository.vo.RelatedCommentVo;
import com.hackaton.hackation2022.domain.feed.facade.FeedFacade;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.CommentResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QueryFeedDetailService {

    private final FeedFacade feedFacade;
    private final CommentRepository commentRepository;

    @Transactional(readOnly = true)
    public FeedDetailResponse execute(Long feedId) {
        Feed feed = feedFacade.getFeedById(feedId);
        return feedDetailResponseBuilder(feed);
    }

    private FeedDetailResponse feedDetailResponseBuilder(Feed feed) {
        List<RelatedCommentVo> comments = commentRepository.findCommentsListByFeed(feed.getId());

        return FeedDetailResponse.builder()
                .title(feed.getTitle())
                .content(feed.getContent())
                .type(feed.getType())
                .user(createUserResponse(feed.getUser()))
                .comments(comments.stream()
                        .map(this::createCommentResponse)
                        .collect(Collectors.toList())
                )
                .build();
    }

    private UserResponse createUserResponse(User user) {
        return new UserResponse(user.getName(), user.getProfileImageUrl());
    }

    private CommentResponse createCommentResponse(RelatedCommentVo vo) {
        return CommentResponse.builder()
                .content(vo.getContent())
                .user(createUserResponse(vo.getUsername(), vo.getProfileImage()))
                .build();
    }

    private UserResponse createUserResponse(String name, String profileImageUrl) {
        return new UserResponse(name, profileImageUrl);
    }
}
