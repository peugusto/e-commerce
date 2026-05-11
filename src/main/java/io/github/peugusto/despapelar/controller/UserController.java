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
    private final UserMapper mapper;

    @PostMapping
    public @NonNull ResponseEntity<ResponseUserDTO> createUser(@Valid @RequestBody RequestUserDTO dto){
        ResponseUserDTO user = service.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.id()).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id){
        Optional<ResponseUserDTO> user = service.findById(id);
         user.ifPresentOrElse(
                obj -> {
                    service.deleteById(obj.id());
                },
                () -> ResponseEntity.notFound().build()
        );
        return ResponseEntity.noContent().build();
    }
}
