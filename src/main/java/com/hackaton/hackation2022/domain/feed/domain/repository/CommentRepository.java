package com.hackaton.hackation2022.domain.feed.domain.repository;

import com.hackaton.hackation2022.domain.feed.domain.Comment;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    List<Comment> findAllByFeedId(Long feedId);
}
