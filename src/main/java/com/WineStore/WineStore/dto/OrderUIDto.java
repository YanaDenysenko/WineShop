package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.Basket;
import com.WineStore.WineStore.model.OrderStatus;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
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
