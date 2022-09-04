package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductCategoryUIMapper;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;
    private final ProductCategoryUIMapper productCategoryUIMapper;

    @PostMapping("/create")
    ProductCategoryUIDto create (
            @RequestBody ProductCategoryRequestDto productCategoryRequestDto){
        return productCategoryService.create(productCategoryRequestDto);
    }

    @GetMapping("/getById/{productCategoryId}")
    ProductCategoryUIDto getById (@PathVariable String productCategoryId){
        return productCategoryUIMapper.mapToDto(
                productCategoryService.getById(Long.parseLong(productCategoryId)));
    }

    @GetMapping("/getAll")
    List<ProductCategoryUIDto> getAllProductCategory(){
        return productCategoryService.getAll().stream()
                .map(productCategoryUIMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/getByName/{productCategoryName}")
    ProductCategoryUIDto getByName (@PathVariable String productCategoryName){
        return productCategoryUIMapper.mapToDto(
                productCategoryService.getByName(productCategoryName));
    }
}
