package com.hackaton.hackation2022.domain.feed.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Writer {
    private final String name;
    private final String profileImageUrl;
}
