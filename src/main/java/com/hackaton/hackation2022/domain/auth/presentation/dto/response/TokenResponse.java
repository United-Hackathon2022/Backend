package com.hackaton.hackation2022.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
public class TokenResponse {
    private String accessToken;
}
