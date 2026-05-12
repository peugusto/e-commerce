package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.database.model.Category;
import io.github.peugusto.despapelar.database.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategorySerivce {

    private final CategoryRepository repository;

    public CategorySerivce(CategoryRepository repository) {
        this.repository = repository;
    }

    public Category save(Category obj){
        return repository.save(obj);
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
