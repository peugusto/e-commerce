package io.github.peugusto.despapelar.controller.dto.response;

import java.time.OffsetDateTime;
import java.util.UUID;

public record ResponseCategoryDTO(
        UUID id,
        String name,
        OffsetDateTime timestamp
) {
}
