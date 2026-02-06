package com.noah.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId; // which product was ordered
    private Integer quantity;
    private Double totalPrice;
    private String status; // PENDING, CONFIRMED, FAILED
    private LocalDateTime orderDate;
}
