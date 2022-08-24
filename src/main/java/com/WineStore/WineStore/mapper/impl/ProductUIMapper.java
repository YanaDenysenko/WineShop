package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.ProductUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductUIMapper implements Mapper<Product, ProductUIDto> {
    ProductCategoryMapper productCategoryMapper;

    @Override
    public ProductUIDto mapToDto(Product product) {
        return ProductUIDto.builder()
                .id(product.getId())
                .vendorCode(product.getVendorCode())
                .name(product.getName())
                .category(productCategoryMapper.mapToDto(product.getCategory()))
                .unitPrice(product.getUnitPrice())
                .manufacturer(product.getManufacturer())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public Product mapToModel(ProductUIDto productUIDto) {
        return null;
    }
}
