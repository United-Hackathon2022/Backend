package com.hackaton.hackation2022.domain.feed.presentation.dto.request;

import com.hackaton.hackation2022.domain.feed.domain.type.FeedType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FeedRequest {

    @NotNull
    @Length(max = 30)
    private String title;

    @NotNull
    @Length(max = 1000)
    private String content;

    @NotNull
    @Length(max = 8)
    private FeedType type;
}
