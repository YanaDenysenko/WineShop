package com.WineStore.WineStore.dto.requestDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderStatusRequestDto {
    private String name;
}
