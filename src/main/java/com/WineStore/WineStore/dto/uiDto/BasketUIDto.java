package com.WineStore.WineStore.dto.uiDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketUIDto {
    private long id;
    private CustomerUIDto customerUIDto;
}
