package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.database.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {


    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product save(Product obj){
    return repository.save(obj);
    }
    public void update(Product obj){
        repository.save(obj);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Optional<Product> findById(UUID id){
        return repository.findById(id);
    }
}
