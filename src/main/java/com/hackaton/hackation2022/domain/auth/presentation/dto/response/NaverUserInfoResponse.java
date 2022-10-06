package com.hackaton.hackation2022.domain.auth.presentation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class NaverUserInfoResponse {
    private final NaverUserInfoElement response;
}
