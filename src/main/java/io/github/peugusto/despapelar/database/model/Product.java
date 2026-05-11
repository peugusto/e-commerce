package io.github.peugusto.despapelar.database.model;


import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name="products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "description", length = 200, nullable = false)
    private String description;

    @Column(name = "price", precision = 18, scale = 2)
    private BigDecimal price;

    @Column(name = "image_url")
    private String imageUrl;

    @ManyToOne
    @JoinColumn(name = "categories_id")
    private Categories categories;
}
