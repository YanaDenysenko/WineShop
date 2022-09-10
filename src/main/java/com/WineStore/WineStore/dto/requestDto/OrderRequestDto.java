package com.WineStore.WineStore.dto.requestDto;

import lombok.Builder;
import lombok.Data;
import java.sql.Timestamp;

@Data
@Builder
public class OrderRequestDto {
    private long basketId;
    private Timestamp orderDate;
    private Timestamp shippedDate;
    private long orderStatusId;
}
