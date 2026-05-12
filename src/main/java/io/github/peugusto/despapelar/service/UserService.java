package io.github.peugusto.despapelar.service;

import io.github.peugusto.despapelar.controller.dto.request.RequestUserDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseUserDTO;
import io.github.peugusto.despapelar.controller.mappers.UserMapper;
import io.github.peugusto.despapelar.database.model.User;
import io.github.peugusto.despapelar.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    public ResponseUserDTO save(RequestUserDTO dto) {

        User user = mapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        User saved = repository.save(user);
        return mapper.toResponse(saved);

    }
    public ResponseUserDTO update(UUID id, RequestUserDTO dto) {

        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setRole(dto.role());

        user.setPassword(passwordEncoder.encode(dto.password()));

        User updated = repository.save(user);
        return mapper.toResponse(updated);
    }

    public void deleteById(UUID id){
        if (repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    public Optional<ResponseUserDTO> findById(UUID id){
        return repository.findById(id)
                .map(mapper::toResponse);
    }
}
