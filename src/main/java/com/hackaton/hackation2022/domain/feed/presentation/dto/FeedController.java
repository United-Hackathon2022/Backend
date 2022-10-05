package com.hackaton.hackation2022.domain.feed.presentation.dto;

import com.hackaton.hackation2022.domain.feed.presentation.dto.request.FeedRequest;
import com.hackaton.hackation2022.domain.feed.service.CreateFeedService;
import com.hackaton.hackation2022.domain.feed.service.DeleteFeedService;
import com.hackaton.hackation2022.domain.feed.service.UpdateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/feed")
@RequiredArgsConstructor
public class FeedController {

    private final CreateFeedService createFeedService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;

    @PostMapping
    public void createFeed(@RequestBody @Valid FeedRequest request) {
        createFeedService.execute(request);
    }

    @PutMapping("/{id}")
    public void updateFeed(@PathVariable Long id, @RequestBody @Valid FeedRequest request) {
        updateFeedService.execute(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteFeed(@PathVariable Long id) {
        deleteFeedService.execute(id);
    }
}
