package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryCreateDto {
    private String name;
}
