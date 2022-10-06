package com.hackaton.hackation2022.domain.feed.presentation;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import com.hackaton.hackation2022.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.hackaton.hackation2022.domain.feed.presentation.dto.response.QueryFeedListResponse;
import com.hackaton.hackation2022.domain.feed.service.CreateFeedService;
import com.hackaton.hackation2022.domain.feed.service.QueryFeedListService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/feeds")
@RequiredArgsConstructor
public class FeedController {
    private final CreateFeedService createFeedService;
    private final QueryFeedListService queryFeedListService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }

    @GetMapping
    public QueryFeedListResponse feedList(@RequestParam("type") FeedType type) {
        return queryFeedListService.execute(type);
    }
}
