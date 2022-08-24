package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.ProductCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductCreateMapper implements Mapper<Product, ProductCreateDto> {

    @Override
    public ProductCreateDto mapToDto(Product product) {
        return null;
    }

    @Override
    public Product mapToModel(ProductCreateDto productCreateDto) {
        return null;
    }
}
