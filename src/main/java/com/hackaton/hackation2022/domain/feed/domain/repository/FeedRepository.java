package com.hackaton.hackation2022.domain.feed.domain.repository;

import com.hackaton.hackation2022.domain.feed.domain.Feed;
import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FeedRepository extends CrudRepository<Feed, Long> {

    List<Feed> findFeedsByType(FeedType type);
}
