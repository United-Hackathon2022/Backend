package com.hackaton.hackation2022.global.entity;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public abstract class BaseTimeEntity {

    @NotNull
    @CreatedDate
    private final LocalDateTime createdAt = LocalDateTime.now();
}
