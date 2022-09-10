package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Product;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductUIMapper implements Mapper<Product, ProductUIDto> {
    private final ProductCategoryUIMapper productCategoryUIMapper;

    @Override
    public ProductUIDto mapToDto(Product product) {
        return ProductUIDto.builder()
                .id(product.getId())
                .vendorCode(product.getVendorCode())
                .name(product.getName())
                .productCategoryUIDto(productCategoryUIMapper.mapToDto(product.getCategory()))
                .unitPrice(product.getUnitPrice())
                .manufacturer(product.getManufacturer())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public Product mapToModel(ProductUIDto productUIDto) {
        Product product = new Product();
        product.setId(productUIDto.getId());
        product.setVendorCode(productUIDto.getVendorCode());
        product.setName(productUIDto.getName());
        product.setCategory(productCategoryUIMapper.mapToModel(
                productUIDto.getProductCategoryUIDto()));
        product.setUnitPrice(productUIDto.getUnitPrice());
        product.setManufacturer(productUIDto.getManufacturer());
        product.setQuantity(productUIDto.getQuantity());
        return product;
    }
}
