package com.WineStore.WineStore.dto.uiDto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
public class OrderUIDto {
    private long id;
    private BasketUIDto basketUIDto;
    private Timestamp orderDate;
    private Timestamp shippedDate;
    private OrderStatusUIDto orderStatusUIDto;
}
