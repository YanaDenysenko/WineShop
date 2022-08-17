package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.ProductCategoryDto;
import com.WineStore.WineStore.model.ProductCategory;

import java.util.List;
import java.util.Optional;

public interface ProductCategoryService {
    ProductCategory save(ProductCategoryDto productCategoryDto);

    Optional<ProductCategory> findById(long id);

    void delete(ProductCategoryDto productCategoryDto);

    List<ProductCategory> findAll();
}
