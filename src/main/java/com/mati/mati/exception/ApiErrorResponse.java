package com.mati.mati.exception;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record ApiErrorResponse(int status, @NotBlank String error, @NotBlank String message) {
}
