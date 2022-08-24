package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDetailsCreateDto {
    private long productId;
    private long basketId;
    private int quantity;
}
