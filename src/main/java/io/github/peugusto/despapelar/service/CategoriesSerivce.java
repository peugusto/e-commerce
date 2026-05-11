package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.database.model.Categories;
import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.database.repository.CategoriesRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class CategoriesSerivce {

    private final CategoriesRepository repository;

    public CategoriesSerivce(CategoriesRepository repository) {
        this.repository = repository;
    }

    public Categories save(Categories obj){
        return repository.save(obj);
    }
    public void update(Categories obj){
        repository.save(obj);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Optional<Categories> findById(UUID id){
        return repository.findById(id);
    }
}
