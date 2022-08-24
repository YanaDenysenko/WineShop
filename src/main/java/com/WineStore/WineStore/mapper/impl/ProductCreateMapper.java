package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.ProductCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductCreateMapper implements Mapper<Product, ProductCreateDto> {
    ProductCategoryService productCategoryService;

    @Override
    public ProductCreateDto mapToDto(Product product) {
        return null;
    }

    @Override
    public Product mapToModel(ProductCreateDto productCreateDto) {
        Product product = new Product();
        product.setVendorCode(productCreateDto.getVendorCode());
        product.setName(productCreateDto.getName());
        product.setCategory(productCategoryService.getByName(
                productCreateDto.getCategory().getName()));
        product.setUnitPrice(productCreateDto.getUnitPrice());
        product.setManufacturer(productCreateDto.getManufacturer());
        product.setQuantity(productCreateDto.getQuantity());
        return product;
    }
}
