package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.ProductDto;
import com.WineStore.WineStore.model.BasketDetails;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BasketDetailsService {
    BasketDetails save(BasketDetails basketDetails);

    Optional<BasketDetails> findById(long id);

    void delete(BasketDetails basketDetails);

    List<BasketDetails> findAll();

    Set<BasketDetails> getAllByProduct(ProductDto productDto);
}
