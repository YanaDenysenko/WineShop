package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import com.WineStore.WineStore.model.ProductCategory;
import java.util.List;

public interface ProductCategoryService {

    ProductCategoryUIDto create(ProductCategoryRequestDto productCategoryRequestDto);

    ProductCategory getById(long id);

    List<ProductCategory> getAll();

    ProductCategory getByName(String name);
}
