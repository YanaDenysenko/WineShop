package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.ProductCategory;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDto {
    private long vendorCode;
    private String name;
    private ProductCategory category;
    private double unitPrice;
    private String manufacturer;
    private int quantity;
}
