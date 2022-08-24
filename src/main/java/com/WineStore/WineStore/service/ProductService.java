package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.ProductCategoryDto;
import com.WineStore.WineStore.dto.ProductCreateDto;
import com.WineStore.WineStore.dto.ProductUIDto;
import com.WineStore.WineStore.model.Product;
import java.util.Set;

public interface ProductService {
    Set<Product> getProductById(long id);

    Set<Product> getProductByCategory(ProductCategoryDto categoryDto);

    Set<Product> getProductByManufacturer (String manufacturer);

    ProductUIDto create(ProductCreateDto productCreateDto);
}
