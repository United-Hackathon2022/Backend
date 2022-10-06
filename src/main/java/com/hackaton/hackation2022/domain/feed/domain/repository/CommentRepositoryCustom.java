package com.hackaton.hackation2022.domain.feed.domain.repository;

import com.hackaton.hackation2022.domain.feed.domain.repository.vo.CommentVo;

import java.util.List;

public interface CommentRepositoryCustom {

    List<CommentVo> findCommentsListByFeed(Long feedId);
}
