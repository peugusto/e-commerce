package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.database.model.OrderItem;
import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.database.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderItemService {

    private final OrderItemRepository repository;

    public OrderItemService(OrderItemRepository repository) {
        this.repository = repository;
    }

    public OrderItem save(OrderItem obj){
        return repository.save(obj);
    }
    public void update(OrderItem obj){
        repository.save(obj);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Optional<OrderItem> findById(UUID id){
        return repository.findById(id);
    }
}
