package io.github.peugusto.despapelar.controller;

import io.github.peugusto.despapelar.controller.dto.request.RequestCategoryDTO;
import io.github.peugusto.despapelar.controller.dto.response.ResponseCategoryDTO;
import io.github.peugusto.despapelar.database.model.Category;
import io.github.peugusto.despapelar.service.CategorySerivce;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/category")
public class CategoryController {

    private final CategorySerivce serivce;

    @PostMapping
    public ResponseEntity<ResponseCategoryDTO> create(@Valid @RequestBody RequestCategoryDTO dto){
        ResponseCategoryDTO cat = serivce.save(dto);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(cat.id()).toUri();
        return ResponseEntity.created(location).body(cat);
    }
}
