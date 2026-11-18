package com.example.Grocery.Entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "userGroceryList")
@Data
@NoArgsConstructor
public class groceryItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Categoty is required")
    @Column(nullable = false)
    private String category;

    @NotBlank(message = "Grocery item is required")
    @Column(nullable = false)
    private String items;

    @Positive(message = "Quantity must be greater than zero")
    @Column(nullable = false)
    private double quantity;
    @Positive(message = "Unit price must be greater than zero")
    @Column(nullable = false)
    private double unitPrice;

    @Enumerated(EnumType.STRING)
    private TaskStatus completeTask;
}
