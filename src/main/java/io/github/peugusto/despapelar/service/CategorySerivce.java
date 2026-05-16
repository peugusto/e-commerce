package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.controller.dto.request.RequestCategoryDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseCategoryDTO;
import io.github.peugusto.despapelar.controller.mappers.CategoryMapper;
import io.github.peugusto.despapelar.database.model.Category;
import io.github.peugusto.despapelar.database.repository.CategoryRepository;
import io.github.peugusto.despapelar.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategorySerivce {

    private final CategoryRepository repository;
    private final CategoryMapper mapper;


    public ResponseCategoryDTO save(RequestCategoryDTO dto){

        if (repository.existsByName(dto.name())) {
            throw new BusinessException("Category already exists");
        }

        Category obj = new Category();
        obj.setName(dto.name());
        Category cat = repository.save(obj);
        return mapper.toResponse(cat);
    }


    public void update(Category obj){
        repository.save(obj);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Optional<Category> findById(UUID id){
        return repository.findById(id);
    }
}
