package com.hackaton.hackation2022.domain.feed.presentation;

import com.hackaton.hackation2022.domain.feed.presentation.dto.request.CreateFeedRequest;
import com.hackaton.hackation2022.domain.feed.service.CreateFeedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/feeds")
@RequiredArgsConstructor
public class FeedController {
    private final CreateFeedService createFeedService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createFeed(@RequestBody @Valid CreateFeedRequest request) {
        createFeedService.execute(request);
    }
}
