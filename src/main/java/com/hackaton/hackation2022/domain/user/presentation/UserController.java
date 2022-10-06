package com.hackaton.hackation2022.domain.user.presentation;

import com.hackaton.hackation2022.domain.user.presentation.dto.response.QueryMyPageResponse;
import com.hackaton.hackation2022.domain.user.service.QueryMyPageService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final QueryMyPageService queryMyPageService;

    @GetMapping
    public QueryMyPageResponse myPage() {
        return queryMyPageService.execute();
    }


}
