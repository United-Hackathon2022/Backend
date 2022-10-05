package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.user.presentation.dto.response.UserResponse;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommentResponse {

    private String content;
    private UserResponse user;

    public static CommentResponse of(Comment comment) {
        return CommentResponse.builder()
                .content(comment.getContent())
                .user(UserResponse.of(comment.getUser()))
                .build();
    }
}
