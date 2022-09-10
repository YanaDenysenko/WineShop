package com.WineStore.WineStore.controller;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {
    private final ProductService productService;

    @PostMapping("/create")
    ProductUIDto create(@RequestBody ProductRequestDto productRequestDto) {
        return productService.create(productRequestDto);
    }

    @PutMapping("/updateById/{productId}")
    ProductUIDto updateById(@RequestBody ProductRequestDto productRequestDto,
                            @PathVariable String productId) {
        return productService.updateById(productRequestDto, Long.parseLong(productId));
    }

    @DeleteMapping("/deleteById/{productId}")
    ProductUIDto deleteById(@PathVariable String productId) {
        return productService.deleteById(Long.parseLong(productId));
    }

    @GetMapping("/getById/{productId}")
    ProductUIDto getById(@PathVariable String productId) {
        return productService.getById(Long.parseLong(productId));
    }

    @GetMapping("/getAll")
    List<ProductUIDto> getAllProduct() {
        return productService.getAll();
    }

    @GetMapping("/getByManufacturer/{productManufacturer}")
    List<ProductUIDto> getByManufacturer(@PathVariable String productManufacturer) {
        return productService.getByManufacturer(productManufacturer);
    }

    @GetMapping("/getAvailable")
    List<ProductUIDto> getAvailableProduct() {
        return productService.getAvailableProduct();
    }

    @GetMapping("/getByOrder/{orderId}")
    List<ProductUIDto> getProductByOrder(@PathVariable String orderId) {
        return productService.getProductByOrder(Long.parseLong(orderId));
    }

    @GetMapping("/getByCategory/{categoryId}")
    List<ProductUIDto> getProductByCategory(@PathVariable String categoryId) {
        return productService.getProductByCategory(Long.parseLong(categoryId));
    }
}
