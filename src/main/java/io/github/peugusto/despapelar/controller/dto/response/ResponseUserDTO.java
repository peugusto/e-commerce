package io.github.peugusto.despapelar.controller.dto.response;

import io.github.peugusto.despapelar.database.enums.UserRole;
import lombok.Data;

import java.util.UUID;


public record ResponseUserDTO(
        UUID id,
        String name,
        String email,
        UserRole role
) {
}
