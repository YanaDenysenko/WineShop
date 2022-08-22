package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.model.OrderStatus;
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
