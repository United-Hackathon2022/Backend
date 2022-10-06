package com.hackaton.hackation2022.domain.auth.service;

import com.hackaton.hackation2022.domain.auth.presentation.dto.response.NaverUserInfoElement;
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
//        String naverToken = "Bearer " + naverTokenClient.getCode(
//                GRANT_TYPE,
//                navertFeginProperties.getClientId(),
//                navertFeginProperties.getClientSecret(),
//                code,
//                navertFeginProperties.getState()).getAccessToken();
//
//
////        String token = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&client_id=" + navertFeginProperties.getClientId() + "&client_secret="
////                + navertFeginProperties.getClientSecret() + "&code=" + code + "&state=hackathon";
//
//        System.out.println(naverToken);
//        NaverUserInfoElement userInfo = naverUserInfoClient.getUserInfo(naverToken).getResponse();
//
//
//
//        User user = userRepository.findByEmail(userInfo.getEmail())
//                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
//
//        User userSave = User.builder()
//                .email(user.getEmail())
//                .name(user.getName())
//                .profileImageUrl(user.getProfileImageUrl())
//                .build();
//
//        userRepository.save(userSave);

        return jwtTokenProvider.getToken("lyutvs@naver.com");
    }
}
