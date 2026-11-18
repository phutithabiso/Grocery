package com.example.Grocery.Sevices;

import com.example.Grocery.DTO.groceryRequest;
import com.example.Grocery.DTO.groceryResponse;
import com.example.Grocery.Entity.groceryItem;
import com.example.Grocery.Exeptions.DuplicateErrorHanding;
import com.example.Grocery.Repository.groceryRepository;
import com.sun.jdi.request.DuplicateRequestException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class groceryServices {
    private final groceryRepository repo;

    public groceryServices(groceryRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public groceryResponse Create(groceryRequest request) {
        //   if(services.response.(request.items())){
        if (repo.existsByItems(request.items())) {
            throw new DuplicateErrorHanding("Item cannot be found");

        }
        groceryItem store = new groceryItem();
        store.setCategory(request.category());
        store.setItems(request.items());
        store.setQuantity(request.quantity());
        store.setUnitPrice(request.unitPrice());
        groceryItem saveItems = repo.save(store);
        return mapToResponse(saveItems);

    }

    @Transactional
    public List<groceryResponse> getAllItems() {

        return repo.findAll()
                .stream()
                .map(item -> mapToResponse(item))
                .toList();
    }


    @Transactional
    public groceryResponse getItemById(Long id) {
        groceryItem findid = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Item not found with ID: " + id));

        return mapToResponse(findid);
    }

    //UPDATE THE IDEMS
    @Transactional
    public groceryResponse Update(Long id, groceryRequest request) {
        groceryItem f = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Items not found with Id" + id));

        if (!f.getItems().equalsIgnoreCase(request.items())
                && repo.existsByItems(request.items())) {
            throw new DuplicateErrorHanding("Item already exists");
        }
        groceryItem update = new groceryItem();
        update.setCategory(request.category());
        update.setItems(request.items());
        update.setQuantity(request.quantity());
        update.setUnitPrice(request.unitPrice());
        groceryItem saveItems = repo.save(update);
        return mapToResponse(saveItems);
    }

    @Transactional
    public String deleteItem(Long id) {

        groceryItem store = repo.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Item not found with ID: " + id));

        repo.delete(store);

        return "Grocery item deleted successfully";
    }

    private groceryResponse mapToResponse(groceryItem store) {

        return new groceryResponse(
                store.getId(),
                store.getCategory(),
                store.getItems(),
                store.getQuantity(),
                store.getUnitPrice(),
                store.getCompleteTask()
        );
    }
}




