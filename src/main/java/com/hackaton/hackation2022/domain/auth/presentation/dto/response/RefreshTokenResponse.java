package com.hackaton.hackation2022.domain.auth.presentation.dto.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class RefreshTokenResponse {

    private final String accessToken;
    private final String refreshToken;
}