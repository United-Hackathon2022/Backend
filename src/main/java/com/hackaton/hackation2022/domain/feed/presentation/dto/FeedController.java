package com.hackaton.hackation2022.domain.feed.presentation.dto;

import com.hackaton.hackation2022.domain.feed.exception.InvalidFeedTypeException;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.FeedRequest;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedResponse;
import com.hackaton.hackation2022.domain.feed.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final QueryFeedsService queryFeedsService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;

    @PostMapping
    public void createFeed(@RequestBody @Valid FeedRequest request) {
        createFeedService.execute(request);
    }

    @GetMapping
    public List<FeedResponse> getFeeds(@RequestParam String type) {
        return queryFeedsService.execute(type);
    }

    @GetMapping("/{feed_id}")
    public FeedDetailResponse getFeedDetail(@PathVariable Long feedId) {
        return queryFeedDetailService.execute(feedId);
    }

    @PutMapping("/{feed_id}")
    public void updateFeed(@PathVariable Long feedId, @RequestBody @Valid FeedRequest request) {
        updateFeedService.execute(feedId, request);
    }

    @DeleteMapping("/{feed_id}")
    public void deleteFeed(@PathVariable Long feedId) {
        deleteFeedService.execute(feedId);
    }
}
