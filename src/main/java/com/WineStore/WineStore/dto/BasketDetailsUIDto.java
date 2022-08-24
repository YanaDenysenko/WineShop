package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDetailsUIDto {
    private long id;
    private ProductDto product;
    private BasketDto basket;
    private int quantity;
}
