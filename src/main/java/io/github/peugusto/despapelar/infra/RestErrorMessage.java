package io.github.peugusto.despapelar.infra;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

public record RestErrorMessage(
        String message,
        OffsetDateTime timestamp
) {
}
