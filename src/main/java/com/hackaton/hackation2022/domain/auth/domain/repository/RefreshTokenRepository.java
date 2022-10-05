package com.hackaton.hackation2022.domain.auth.domain.repository;

import com.hackaton.hackation2022.domain.auth.domain.RefreshToken;
import org.springframework.data.repository.CrudRepository;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, String> {
}
