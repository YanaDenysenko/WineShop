package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OrderStatusUIDto {
    private long id;
    private String name;
}
