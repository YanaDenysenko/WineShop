package com.WineStore.WineStore.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketUIDto {
    private long id;
    private CustomerDto customer;
}
