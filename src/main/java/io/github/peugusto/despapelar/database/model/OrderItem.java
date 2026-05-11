package io.github.peugusto.despapelar.database.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "order_item")
@Data
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product_id" , nullable = false)
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "unite_price")
    private BigDecimal unitePrice;
}
