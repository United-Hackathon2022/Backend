package com.hackaton.hackation2022.domain.user.presentation.dto.response;

import com.hackaton.hackation2022.domain.user.domain.User;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private String name;
    private String profileImageUrl;

    public static UserResponse of(User user) {

    }
}
