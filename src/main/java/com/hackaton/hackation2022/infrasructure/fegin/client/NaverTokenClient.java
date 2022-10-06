package com.hackaton.hackation2022.infrasructure.fegin.client;

import com.hackaton.hackation2022.domain.auth.presentation.dto.response.TokenResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "naverFeignClient", url = "https://nid.naver.com/oauth2.0/token")
public interface NaverTokenClient {

    @PostMapping
    TokenResponse getCode(@RequestParam("grant_type") String grantType,
                          @RequestParam("client_id") String clientId,
                          @RequestParam("client_secret") String clientSecret,
                          @RequestParam String code,
                          @RequestParam String state);
}
