package io.github.peugusto.despapelar.controller.mappers;

import io.github.peugusto.despapelar.controller.dto.request.RequestProductDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseCategoryDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseProductDTO;
import io.github.peugusto.despapelar.database.model.Category;
import io.github.peugusto.despapelar.database.model.Product;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface ProductMapper {

    ResponseProductDTO toResponse(Product product);
    Product toEntity(RequestProductDTO dto);
    ResponseCategoryDTO toCategoryResponse(Category category);
}
