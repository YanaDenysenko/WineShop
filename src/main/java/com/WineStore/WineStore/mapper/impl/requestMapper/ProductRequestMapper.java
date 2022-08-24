package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class ProductRequestMapper implements Mapper<Product, ProductRequestDto> {
    ProductCategoryService productCategoryService;

    @Override
    public ProductRequestDto mapToDto(Product product) {
        return null;
    }

    @Override
    public Product mapToModel(ProductRequestDto productRequestDto) {
        Product product = new Product();
        product.setVendorCode(productRequestDto.getVendorCode());
        product.setName(productRequestDto.getName());
        product.setCategory(productCategoryService.getByName(
                productRequestDto.getProductCategoryRequestDto().getName()));
        product.setUnitPrice(productRequestDto.getUnitPrice());
        product.setManufacturer(productRequestDto.getManufacturer());
        product.setQuantity(productRequestDto.getQuantity());
        return product;
    }
}
