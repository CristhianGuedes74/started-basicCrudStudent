package com.crud.basic.exceptions;

import java.time.LocalDateTime;
import java.util.Map;

public record ErrorResponseDTO(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path,
    Map<String, String> validationsError
) {}
