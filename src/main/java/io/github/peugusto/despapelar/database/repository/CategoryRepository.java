package io.github.peugusto.despapelar.database.repository;

import io.github.peugusto.despapelar.database.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, UUID> {
    Boolean existsByName(String name);
}
