package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.ProductCategoryUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryUIMapper implements Mapper<ProductCategory, ProductCategoryUIDto> {

    @Override
    public ProductCategoryUIDto mapToDto(ProductCategory productCategory) {
        return ProductCategoryUIDto.builder()
                .id(productCategory.getId())
                .name(productCategory.getName())
                .build();
    }

    @Override
    public ProductCategory mapToModel(ProductCategoryUIDto productCategoryUIDto) {
        return null;
    }
}
