package io.github.peugusto.despapelar.database.repository;

import io.github.peugusto.despapelar.database.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
