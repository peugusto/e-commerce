package io.github.peugusto.despapelar.controller.mappers;

import io.github.peugusto.despapelar.controller.dto.response.ResponseCategoryDTO;
import io.github.peugusto.despapelar.database.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    ResponseCategoryDTO toResponse(Category obj);
}
