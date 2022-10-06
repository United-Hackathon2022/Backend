package com.hackaton.hackation2022.domain.feed.domain.repository;

import com.hackaton.hackation2022.domain.feed.domain.repository.vo.RelatedCommentVo;

import java.util.List;

public interface CommentRepositoryCustom {

    List<RelatedCommentVo> findCommentsListByFeed(Long feedId);
}
