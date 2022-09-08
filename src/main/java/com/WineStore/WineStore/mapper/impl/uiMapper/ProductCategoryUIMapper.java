package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
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
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(productCategoryUIDto.getId());
        productCategory.setName(productCategoryUIDto.getName());
        return productCategory;
    }
}
