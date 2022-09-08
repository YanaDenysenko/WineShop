package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import com.WineStore.WineStore.service.ProductCategoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/productCategory")
public class ProductCategoryController {
    private final ProductCategoryService productCategoryService;

    @PostMapping("/create")
    ProductCategoryUIDto create(
            @RequestBody ProductCategoryRequestDto productCategoryRequestDto) {
        return productCategoryService.create(productCategoryRequestDto);
    }

    @PutMapping("/updateById/{productCategoryId}")
    ProductCategoryUIDto updateById(
            @RequestBody ProductCategoryRequestDto productCategoryRequestDto,
            @PathVariable String productCategoryId) {
        return productCategoryService.updateById(productCategoryRequestDto,
                Long.parseLong(productCategoryId));
    }

    @DeleteMapping("/deleteById/{productCategoryId}")
    ProductCategoryUIDto deleteById(@PathVariable String productCategoryId) {
        return productCategoryService.deleteById(Long.parseLong(productCategoryId));
    }

    @GetMapping("/getById/{productCategoryId}")
    ProductCategoryUIDto getById(@PathVariable String productCategoryId) {
        return productCategoryService.getById(Long.parseLong(productCategoryId));
    }

    @GetMapping("/getAll")
    List<ProductCategoryUIDto> getAllProductCategory() {
        return productCategoryService.getAll();
    }

    @GetMapping("/getByName/{productCategoryName}")
    ProductCategoryUIDto getByName(@PathVariable String productCategoryName) {
        return productCategoryService.getByName(productCategoryName);
    }
}
