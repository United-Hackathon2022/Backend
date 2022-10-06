package com.hackaton.hackation2022.domain.user.facade;

import com.hackaton.hackation2022.domain.user.domain.User;
import com.hackaton.hackation2022.domain.user.domain.repository.UserRepository;
import com.hackaton.hackation2022.domain.user.exception.UserNotFoundException;
import com.hackaton.hackation2022.global.security.jwt.auth.AuthDetails;
import com.hackaton.hackation2022.global.security.jwt.exception.CredentialsNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserFacade {

    private final UserRepository userRepository;

    public User queryCurrentUser() {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (!(principal instanceof AuthDetails)) {
            throw CredentialsNotFoundException.EXCEPTION;
        }

        return userRepository.findByEmail(((AuthDetails) principal).getUsername())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
