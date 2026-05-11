package io.github.peugusto.despapelar.controller.dto.request;

import io.github.peugusto.despapelar.database.enums.UserRole;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RequestUserDTO(
        @NotBlank
        @Size(max = 50)
        String name,
        @NotBlank
        @Size(max = 50)
        String email,
        @NotBlank
        String password,
        @NotNull
        UserRole role
) {
}
