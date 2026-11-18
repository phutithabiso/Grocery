package com.example.Grocery.DTO;

import com.example.Grocery.Entity.TaskStatus;

public record groceryResponse (
        Long id,
        String category,
        String items,
        double quantity,
        double unitPrice,
        TaskStatus completeTask
    )
{

}
