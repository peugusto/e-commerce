package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.controller.dto.request.RequestProductDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseProductDTO;
import io.github.peugusto.despapelar.controller.mappers.ProductMapper;
import io.github.peugusto.despapelar.database.model.Category;
import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.database.repository.CategoryRepository;
import io.github.peugusto.despapelar.database.repository.ProductRepository;
import io.github.peugusto.despapelar.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final CategoryRepository categoryRepository;
    private final ProductRepository repository;
    private final ProductMapper mapper;

    public ResponseProductDTO save(RequestProductDTO dto) {
        Product obj = mapper.toEntity(dto);
        Category cat = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        obj.setCategory(cat);
        Product saved = repository.save(obj);
        return mapper.toResponse(saved);
    }


    public ResponseProductDTO update(UUID id, RequestProductDTO dto){
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found"));

        Category category = categoryRepository.findById(dto.categoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Category not found"));

        product.setName(dto.name());
        product.setPrice(dto.price());
        product.setDescription(dto.description());
        product.setImageUrl(dto.imageUrl());
        product.setCategory(category);

        Product saved = repository.save(product);
        return mapper.toResponse(saved);
    }

    public void deleteById(UUID id){
        if (!repository.existsById(id)){
            throw new ResourceNotFoundException("Product not found");
        }
        repository.deleteById(id);
    }

    public Optional<ResponseProductDTO> findById(UUID id){
        return repository.findById(id)
                .map(mapper::toResponse);
    }
}
