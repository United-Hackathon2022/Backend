package com.hackaton.hackation2022.domain.auth.presentation;

import com.hackaton.hackation2022.domain.auth.presentation.dto.response.TokenResponse;
import com.hackaton.hackation2022.domain.auth.service.NaverOauthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/auth")
@RestController
public class AuthController {
    private final NaverOauthService naverOauthService;

    @GetMapping("/naver/redirect")
    public TokenResponse getNaverCode(@RequestParam String code) {
        return naverOauthService.getCode(code);
    }

}
