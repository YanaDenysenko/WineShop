package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.Customer;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDto {
    private Customer customer;
}
