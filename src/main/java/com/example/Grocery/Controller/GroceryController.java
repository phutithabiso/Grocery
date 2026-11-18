
package com.example.Grocery.Controller;

import com.example.Grocery.DTO.groceryRequest;
import com.example.Grocery.DTO.groceryResponse;
import com.example.Grocery.Sevices.groceryServices;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/grocery")
public class GroceryController {

    private final groceryServices services;

    public GroceryController(groceryServices services) {
        this.services = services;
    }

    @PostMapping("/create")
    public groceryResponse createItem(
            @RequestBody groceryRequest request) {

        return services.Create(request);
    }

    @GetMapping("/all")
    public List<groceryResponse> getAllItems() {

        return services.getAllItems();
    }

    @GetMapping("/{id}")
    public groceryResponse getItemById(
            @PathVariable Long id) {

        return services.getItemById(id);
    }

    @PutMapping("/update/{id}")
    public groceryResponse updateItem(
            @PathVariable Long id,
            @RequestBody groceryRequest request) {

        return services.Update(id, request);
    }


    @DeleteMapping("/delete/{id}")
    public String deleteItem(@PathVariable Long id) {

        return services.deleteItem(id);
    }
}
