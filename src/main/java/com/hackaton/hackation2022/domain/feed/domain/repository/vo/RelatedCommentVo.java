package com.hackaton.hackation2022.domain.feed.domain.repository.vo;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Getter;

@Getter
public class RelatedCommentVo {

    private final String content;
    private final String username;
    private final String profileImage;

    @QueryProjection
    public RelatedCommentVo(String content, String username, String profileImage) {
        this.content = content;
        this.username = username;
        this.profileImage = profileImage;
    }
}
