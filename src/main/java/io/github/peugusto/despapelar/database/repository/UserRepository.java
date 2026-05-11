package io.github.peugusto.despapelar.database.repository;

import io.github.peugusto.despapelar.database.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
