package com.example.Grocery.DTO;

public record grocertRequest(
    String category,
    String items,
    double quantity,
    double unitPrice,
    String completeTask
    )
    {

}
