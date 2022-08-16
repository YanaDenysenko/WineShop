package com.WineStore.WineStore.mapper;

import com.WineStore.WineStore.dto.ProductCategoryDto;
import com.WineStore.WineStore.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryMapper implements Mapper<ProductCategory, ProductCategoryDto>{
    @Override
    public ProductCategoryDto mapToDto(ProductCategory productCategory) {
        return null;
    }

    @Override
    public ProductCategory mapToModel(ProductCategoryDto productCategoryDto) {
        return null;
    }
}
