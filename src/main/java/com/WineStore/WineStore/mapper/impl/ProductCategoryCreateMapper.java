package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.ProductCategoryCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryCreateMapper implements
        Mapper<ProductCategory, ProductCategoryCreateDto> {

    @Override
    public ProductCategoryCreateDto mapToDto(ProductCategory productCategory) {
        return null;
    }

    @Override
    public ProductCategory mapToModel(ProductCategoryCreateDto productCategoryCreateDto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryCreateDto.getName());
        return productCategory;
    }
}
