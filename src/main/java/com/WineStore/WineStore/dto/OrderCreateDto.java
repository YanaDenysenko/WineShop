package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
public class OrderCreateDto {
    private long basketId;
    private Timestamp orderDate;
    private Timestamp shippedDate;
    private OrderStatusDto orderStatusDto;
}
