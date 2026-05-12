package io.github.peugusto.despapelar.controller.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record ResponseProductDTO(
        UUID id,
        String name,
        String description,
        BigDecimal price,
        String imageUrl,
        ResponseCategoryDTO category
) {
}
