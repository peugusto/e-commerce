package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.database.model.Order;
import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.database.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class OrderService {


    private final OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order save(Order obj){
        return repository.save(obj);
    }
    public void update(Order obj){
        repository.save(obj);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Optional<Order> findById(UUID id){
        return repository.findById(id);
    }
}
