package com.hackaton.hackation2022.domain.auth.service;

import com.hackaton.hackation2022.domain.auth.presentation.dto.response.NaverUserINfoElement;
import com.hackaton.hackation2022.domain.auth.presentation.dto.response.NaverUserInfoResponse;
import com.hackaton.hackation2022.domain.auth.presentation.dto.response.TokenResponse;
import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.domain.repository.UserRepository;
import com.hackaton.hackation2022.domain.user.exception.UserNotFoundException;
import com.hackaton.hackation2022.global.security.jwt.JwtTokenProvider;
import com.hackaton.hackation2022.global.security.jwt.NavertFeginProperties;
import com.hackaton.hackation2022.infrasructure.fegin.client.NaverTokenClient;
import com.hackaton.hackation2022.infrasructure.fegin.client.NaverUserInfoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class NaverOauthService {
    private final NaverTokenClient naverTokenClient;
    private final NaverUserInfoClient naverUserInfoClient;
    private final NavertFeginProperties navertFeginProperties;
    private final UserRepository userRepository;
    private final JwtTokenProvider jwtTokenProvider;

    private static String GRANT_TYPE = "authorization_code";

    public TokenResponse getCode(String code) {
        String naverToken = "Bearer " + naverTokenClient.getCode(
                GRANT_TYPE,
                navertFeginProperties.getClientId(),
                navertFeginProperties.getClientSecret(),
                code,
                navertFeginProperties.getState());

        NaverUserInfoResponse userInfo = naverUserInfoClient.getUserInfo(naverToken);
        User user = userRepository.findByEmail(userInfo.getResponse().getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        NaverUserINfoElement userInfoBuilder = userInfo.getResponse();

        User userSave = User.builder()
                .email(user.getEmail())
                .name(userInfoBuilder.getName())
                .profileImageUrl(userInfoBuilder.getProfileImage())
                .build();

        userRepository.save(userSave);

        return jwtTokenProvider.getToken(userInfoBuilder.getEmail());
    }
}
