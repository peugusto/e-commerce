package io.github.peugusto.despapelar.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record RequestCategoryDTO(
        @NotBlank
        @Size(max = 50)
        String name
) {
}
