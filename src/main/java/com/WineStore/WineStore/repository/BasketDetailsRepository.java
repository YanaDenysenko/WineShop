package com.WineStore.WineStore.repository;

import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface BasketDetailsRepository extends JpaRepository<BasketDetails, Long> {

    List<BasketDetails> getAllByProduct(Product product);
}
