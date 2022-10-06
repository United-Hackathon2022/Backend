package com.hackaton.hackation2022.domain.feed.presentation;


import com.hackaton.hackation2022.domain.feed.presentation.dto.request.CreateCommentRequest;
import com.hackaton.hackation2022.domain.feed.service.CreateCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentController {
    private final CreateCommentService createCommentService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/{feed-id}")
    public void createComment(@PathVariable("feed-id") Long feedId, @RequestBody @Valid CreateCommentRequest request) {
        createCommentService.execute(request, feedId);
    }
}
