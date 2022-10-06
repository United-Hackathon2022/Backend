package com.hackaton.hackation2022.domain.feed.domain.repository;

import com.hackaton.hackation2022.domain.feed.domain.Comment;
import com.hackaton.hackation2022.domain.feed.domain.Feed;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface CommentRepository extends CrudRepository<Comment, Long> {
    Optional<Comment> findAllByFeedId(Long feedId);
}
