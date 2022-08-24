package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.model.Product;
import java.util.List;

public interface ProductService {

    ProductUIDto create(ProductRequestDto productRequestDto);

    Product getById(long id);

    List<Product> getAll();
}
