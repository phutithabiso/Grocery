package com.example.Grocery.DTO;

import com.example.Grocery.Entity.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

public record groceryRequest(
        @NotBlank(message = "Categoty is required")
        @Column(nullable = false)
        String category,

        @NotBlank(message = "Grocery item is required")
        @Column(nullable = false)
        String items,
        @Positive(message = "Quantity must be greater than zero")
        @Column(nullable = false)
        double quantity,
        @Positive(message = "Unit price must be greater than zero")
        @Column(nullable = false)
        double 	unitPrice,

        @Enumerated(EnumType.STRING)
        TaskStatus completeTask
    )
    {

}


