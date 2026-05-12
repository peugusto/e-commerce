package io.github.peugusto.despapelar.controller;

import io.github.peugusto.despapelar.controller.dto.request.RequestUserDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseUserDTO;
import io.github.peugusto.despapelar.controller.mappers.UserMapper;
import io.github.peugusto.despapelar.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService service;

    @PostMapping
    public @NonNull ResponseEntity<ResponseUserDTO> create(@Valid @RequestBody RequestUserDTO dto){
        ResponseUserDTO user = service.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> findById(@PathVariable("id") UUID id){
        Optional<ResponseUserDTO> user = service.findById(id);
        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseUserDTO> update(@PathVariable("id") UUID id, @Valid @RequestBody RequestUserDTO dto){
        ResponseUserDTO user = service.update(id,dto);
        return ResponseEntity.ok(user);
    }


}
