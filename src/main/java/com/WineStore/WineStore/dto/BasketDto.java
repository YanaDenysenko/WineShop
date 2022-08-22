package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.model.Customer;
import com.WineStore.WineStore.model.Order;
import lombok.Builder;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder

public class BasketDto {
    private Customer customer;
}
