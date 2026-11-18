package com.example.Grocery.Entity;

import jakarta.persistence.*;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name ="userGroceryList")
@Data
@NoArgsConstructor
public class groceryItem
{
    @id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Categoty is required")
    @Column(nullable = false,length = 30)
    private String category;

    @NotBlank(message = "Grocery item is required")
    @Column(nullable = false,length = 50)
    private String items;

    @NotBlank(message = " Quantity  is required")
    @Column(nullable = false,length = 20)
    private double quantity;
    @NotBlank(message = "Unit Price is required")
    @Column(nullable = false,length = 30)
    private double 	unitPrice;

    @Enumerated(EnumType.STRING)
    private String completeTask;
}
