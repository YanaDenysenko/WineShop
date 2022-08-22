package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
public class OrderUIDto {
    private long id;
    private BasketDto basket;
    private Timestamp orderDate;
    private Timestamp shippedDate;
    private OrderStatusDto status;
}
