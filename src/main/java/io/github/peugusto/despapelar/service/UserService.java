package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.database.model.User;
import io.github.peugusto.despapelar.database.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User save(User obj){
        return repository.save(obj);
    }
    public void update(User obj){
        repository.save(obj);
    }
    public void deleteById(UUID id){
        repository.deleteById(id);
    }

    public Optional<User> findById(UUID id){
        return repository.findById(id);
    }
}
