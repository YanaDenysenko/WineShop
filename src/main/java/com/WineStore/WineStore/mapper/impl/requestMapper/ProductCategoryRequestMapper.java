package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryRequestMapper implements
        Mapper<ProductCategory, ProductCategoryRequestDto> {

    @Override
    public ProductCategoryRequestDto mapToDto(ProductCategory productCategory) {
        return null;
    }

    @Override
    public ProductCategory mapToModel(ProductCategoryRequestDto productCategoryRequestDto) {
        ProductCategory productCategory = new ProductCategory();
        productCategory.setName(productCategoryRequestDto.getName());
        return productCategory;
    }
}
