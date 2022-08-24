package com.WineStore.WineStore.dto.uiDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDetailsUIDto {
    private long id;
    private ProductUIDto productUIDto;
    private BasketUIDto basketUIDto;
    private int quantity;
}
