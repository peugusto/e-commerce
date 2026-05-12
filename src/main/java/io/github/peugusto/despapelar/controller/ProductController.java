package io.github.peugusto.despapelar.controller;


import io.github.peugusto.despapelar.controller.dto.request.RequestProductDTO;
import io.github.peugusto.despapelar.controller.dto.request.RequestUserDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseProductDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseUserDTO;
import io.github.peugusto.despapelar.controller.mappers.ProductMapper;
import io.github.peugusto.despapelar.database.model.Product;
import io.github.peugusto.despapelar.service.ProductService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductMapper mapper;
    private final ProductService service;

    @PostMapping
    public @NonNull ResponseEntity<ResponseProductDTO> create(@Valid @RequestBody RequestProductDTO dto){
        ResponseProductDTO product = service.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(product.id()).toUri();
        return ResponseEntity.created(location).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id){
        service.deleteById(id);
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> update(@PathVariable("id") UUID id, @Valid @RequestBody RequestProductDTO dto){
        ResponseProductDTO obj = service.update(id,dto);
        return ResponseEntity.ok(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseProductDTO> findById(@PathVariable("id") UUID id){
       Optional<ResponseProductDTO> obj = service.findById(id);
        return service.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
