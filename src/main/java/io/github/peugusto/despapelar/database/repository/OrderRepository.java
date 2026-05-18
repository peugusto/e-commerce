package io.github.peugusto.despapelar.database.repository;

import io.github.peugusto.despapelar.database.enums.OrderStatus;
import io.github.peugusto.despapelar.database.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order,UUID> {
    Optional<Order> findByUserIdAndStatus(Long userId, OrderStatus status);

}
