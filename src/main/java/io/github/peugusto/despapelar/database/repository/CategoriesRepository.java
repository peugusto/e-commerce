package io.github.peugusto.despapelar.database.repository;

import io.github.peugusto.despapelar.database.model.Categories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoriesRepository extends JpaRepository<Categories, UUID> {
}
