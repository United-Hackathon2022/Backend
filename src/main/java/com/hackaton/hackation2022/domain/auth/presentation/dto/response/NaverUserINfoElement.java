package com.hackaton.hackation2022.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class NaverUserINfoElement {
    private final String email;
    private final String name;
    private final String profileImage;
    private final String gender;
}
