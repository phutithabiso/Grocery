package com.example.Grocery.Repository;

import com.example.Grocery.Entity.groceryItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface groceryRepository extends JpaRepository<groceryItem,Long>{
    @Override
    Optional<groceryItem> findById(Long id);
    boolean exitsByItem(String items);
    boolean exitsByItemAndId(String items,Long id );

}
