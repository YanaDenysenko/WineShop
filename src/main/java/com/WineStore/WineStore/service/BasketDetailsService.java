package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.ProductDto;
import com.WineStore.WineStore.model.BasketDetails;

import java.util.Set;

public interface BasketDetailsService {
    Set<BasketDetails> getAllByProduct(ProductDto productDto);
}
