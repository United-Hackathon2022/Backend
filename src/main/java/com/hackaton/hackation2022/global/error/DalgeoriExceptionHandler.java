package com.hackaton.hackation2022.global.error;

import com.hackaton.hackation2022.global.error.exception.DalgeoriException;
import com.hackaton.hackation2022.global.error.exception.ErrorCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@RestControllerAdvice
public class DalgeoriExceptionHandler {

    @ResponseStatus(value = HttpStatus.CONFLICT)
    @ExceptionHandler(DalgeoriException.class)
    public ErrorResponse handleDalgeoriException(DalgeoriException e, HttpServletRequest request) {
        log.error("errorCode: {}, url: {}, message: {}",
                e.getErrorCode(), request.getRequestURI(), e.getMessage());

        return new ErrorResponse(e.getErrorCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleBadRequest(MethodArgumentNotValidException e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return ErrorResponse.builder()
                .status(ErrorCode.BAD_REQUEST.getStatus())
                .message(
                        e.getBindingResult().getFieldErrors().get(0).getField() + "의 " +
                                e.getBindingResult().getFieldErrors().get(0).getDefaultMessage())
                .build();
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e, HttpServletRequest request) {
        log.error("url: {}, message: {}", request.getRequestURI(), e.getMessage());

        return new ErrorResponse(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
