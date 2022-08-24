package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductCategoryUIDto {
    private long id;
    private String name;
}
