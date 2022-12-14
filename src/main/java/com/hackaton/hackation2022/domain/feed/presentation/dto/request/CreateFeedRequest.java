package com.hackaton.hackation2022.domain.feed.presentation.dto.request;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
public class CreateFeedRequest {

    @NotBlank
    @Length(max = 30)
    private String title;

    @NotBlank
    @Length(max = 1000)
    private String content;

    private FeedType type;
}