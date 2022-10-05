package com.hackaton.hackation2022.domain.user.domain.repository;

import com.hackaton.hackation2022.domain.user.domain.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
