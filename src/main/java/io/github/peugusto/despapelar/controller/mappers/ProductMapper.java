package io.github.peugusto.despapelar.controller.mappers;

import io.github.peugusto.despapelar.controller.dto.response.ResponseCategoryDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseProductDTO;
import io.github.peugusto.despapelar.database.model.Category;
import io.github.peugusto.despapelar.database.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mapping(target = "category", source = "category")
    ResponseProductDTO toResponse(Product product);
    ResponseCategoryDTO toCategoryResponse(Category category);
}
