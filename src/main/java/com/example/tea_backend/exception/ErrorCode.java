package com.example.tea_backend.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
    INVALID_USER(404, "MEMBER-ERR-404", "INVALID USER"),
    WRONG_PASSWORD(400, "MEMBER-ERR-400", "WRONG PASSWORD");

    private final int status;       // HTTP 상태 코드
    private final String errorCode; // 에러 코드
    private final String message;// 에러 메시지
}