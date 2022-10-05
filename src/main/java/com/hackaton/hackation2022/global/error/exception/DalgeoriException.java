package com.hackaton.hackation2022.global.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public abstract class DalgeoriException extends RuntimeException {

    private final ErrorProperty errorProperty;
}
