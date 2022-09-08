package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import java.util.List;

public interface ProductService {

    ProductUIDto create(ProductRequestDto productRequestDto);

    ProductUIDto updateById(ProductRequestDto productRequestDto, long id);

    ProductUIDto deleteById(long id);

    ProductUIDto getById(long id);

    List<ProductUIDto> getAll();

    List<ProductUIDto> getByManufacturer(String manufacturer);

    List<ProductUIDto> getAvailableProduct();

    List<ProductUIDto> getProductByOrder(long orderId);

    List<ProductUIDto> getProductByCategory(long categoryId);
}
