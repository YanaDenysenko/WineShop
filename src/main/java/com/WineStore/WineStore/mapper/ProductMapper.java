package com.WineStore.WineStore.mapper;

import com.WineStore.WineStore.dto.ProductDto;
import com.WineStore.WineStore.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements Mapper<ProductDto, Product>{

    @Override
    public ProductDto mapToDto(Product product) {
        return ProductDto.builder()
                .name(product.getName())
                .category(product.getCategory())
                .vendorCode(product.getVendorCode())
                .basketDetails(product.getBasketDetails())
                .build();
    }

    @Override
    public Product mapToModel(ProductDto productDto) {
        Product product = new Product();
        product.setCategory(productDto.getCategory());
        return product;
    }
}
