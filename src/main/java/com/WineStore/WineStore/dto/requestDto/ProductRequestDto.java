package com.WineStore.WineStore.dto.requestDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductRequestDto {
    private long vendorCode;
    private String name;
    private long productCategoryId;
    private double unitPrice;
    private String manufacturer;
    private int quantity;
}
