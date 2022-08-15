package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.model.ProductCategory;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDto {
    private long vendorCode;
    private String name;
    private ProductCategory category;
    private List<BasketDetails> basketDetails;
}
