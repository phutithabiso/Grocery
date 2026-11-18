package com.example.Grocery.DTO;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;

public class groceryResponse {
    @NotBlank(message = "Categoty is required")
    @Column(nullable = false,length = 30)
    String category;

    @NotBlank(message = "Grocery item is required")
    @Column(nullable = false,length = 50)
    String items;

    @NotBlank(message = " Quantity  is required")
    @Column(nullable = false,length = 20)
    double quantity;
    @NotBlank(message = "Unit Price is required")
    @Column(nullable = false,length = 30)
    double 	unitPrice;

    @Enumerated(EnumType.STRING)
    String completeTask;
}
