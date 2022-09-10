package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import java.util.List;

public interface ProductCategoryService {

    ProductCategoryUIDto create(ProductCategoryRequestDto productCategoryRequestDto);

    ProductCategoryUIDto updateById(ProductCategoryRequestDto productCategoryRequestDto, long id);

    ProductCategoryUIDto deleteById(long id);

    ProductCategoryUIDto getById(long id);

    List<ProductCategoryUIDto> getAll();

    ProductCategoryUIDto getByName(String name);
}
