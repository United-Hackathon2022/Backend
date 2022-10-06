package com.hackaton.hackation2022.infrasructure.fegin.client;

import com.hackaton.hackation2022.domain.auth.presentation.dto.response.NaverUserInfoResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(name = "NaverInfoClient", url = "https://openapi.naver.com/v1/nid/me")
public interface NaverUserInfoClient {

    @GetMapping
    NaverUserInfoResponse getUserInfo(@RequestHeader("Authorization") String authorization);

}
