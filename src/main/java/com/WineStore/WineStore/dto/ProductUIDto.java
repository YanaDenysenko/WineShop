package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductUIDto {
    private long id;
    private long vendorCode;
    private String name;
    private ProductCategoryDto category;
    private double unitPrice;
    private String manufacturer;
    private int quantity;
}
