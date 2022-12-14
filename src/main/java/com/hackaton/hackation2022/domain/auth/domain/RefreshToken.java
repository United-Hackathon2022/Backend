package com.hackaton.hackation2022.domain.auth.domain;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@RedisHash
public class RefreshToken {

    @Id
    private String email;

    @Indexed
    private String refreshToken;

    private Long timeToLive;

    @Builder
    public RefreshToken(String email, String refreshToken, Long timeToLive) {
        this.email = email;
        this.refreshToken = refreshToken;
        this.timeToLive = timeToLive;
    }
}
