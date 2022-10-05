package com.hackaton.hackation2022.domain.feed.presentation.dto;

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
    private final QueryQuestionFeedService queryQuestionFeedService;
    private final QueryJobOfferFeedService queryJobOfferFeedService;
    private final QueryFeedDetailService queryFeedDetailService;
    private final UpdateFeedService updateFeedService;
    private final DeleteFeedService deleteFeedService;

    @PostMapping
    public void createFeed(@RequestBody @Valid FeedRequest request) {
        createFeedService.execute(request);
    }

    @GetMapping
    public List<FeedResponse> getFeeds(@RequestParam String type) {
        if (type.equals("question")) {
            return queryQuestionFeedService.execute();
        } else if (type.equals("jon-offer")) {
            return queryJobOfferFeedService.execute();
        } else {
            // TODO :: BAD REQUEST exception
        }
    }

    @GetMapping("/{id}")
    public FeedDetailResponse getFeedDetail(@PathVariable Long id) {
        return queryFeedDetailService.execute(id);
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
