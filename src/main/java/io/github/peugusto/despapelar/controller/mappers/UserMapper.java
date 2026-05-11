package io.github.peugusto.despapelar.controller.mappers;

import io.github.peugusto.despapelar.controller.dto.request.RequestUserDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseUserDTO;
import io.github.peugusto.despapelar.database.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(RequestUserDTO obj);
    ResponseUserDTO toResponse(User obj);
}
