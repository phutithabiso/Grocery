package com.example.Grocery.Repository;

import com.example.Grocery.Entity.groceryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface groceryRepository extends JpaRepository<groceryItem,Long>{
    @Override
    Optional<groceryItem> findById(Long id);
    boolean existsByItems(String items);
    //boolean exitsByItemAndId(String items,Long id );

}
