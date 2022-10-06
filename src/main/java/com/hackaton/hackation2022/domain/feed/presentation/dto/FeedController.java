package com.hackaton.hackation2022.domain.feed.presentation.dto;

import com.hackaton.hackation2022.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.UpdateFeedRequest;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedDetailResponse;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.FeedListResponse;
import com.hackaton.hackation2022.domain.feed.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final QueryFeedListService queryFeedListService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @GetMapping
    public FeedListResponse getFeedList(@RequestParam String type) {
        return queryFeedListService.execute(type);
    }

    @GetMapping("/{feed-id}")
    public FeedDetailResponse getFeedDetail(@PathVariable Long feedId) {
        return queryFeedDetailService.execute(feedId);
    }

    @PutMapping("/{feed-id}")
    public void updateFeed(@PathVariable Long feedId, @RequestBody @Valid UpdateFeedRequest request) {
        updateFeedService.execute(feedId, request);
    }

    @DeleteMapping("/{feed-id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteFeed(@PathVariable Long feedId) {
        deleteFeedService.execute(feedId);
    }
}
