package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCreateDto {
    private long vendorCode;
    private String name;
    private ProductCategoryDto categoryDto;
    private double unitPrice;
    private String manufacturer;
    private int quantity;
}
