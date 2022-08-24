package com.WineStore.WineStore.dto.requestDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDetailsRequestDto {
    private long productId;
    private long basketId;
    private int quantity;
}
