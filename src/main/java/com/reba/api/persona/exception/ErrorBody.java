package com.reba.api.persona.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class ErrorBody {

    private int statusCode;
    private LocalDateTime timestamp;
    private String message;
}
