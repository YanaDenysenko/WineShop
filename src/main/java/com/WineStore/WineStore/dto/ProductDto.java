package com.WineStore.WineStore.dto;

import com.WineStore.WineStore.model.BasketDetails;
import com.WineStore.WineStore.model.ProductCategory;
import com.WineStore.WineStore.model.Wine;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class ProductDto {
    private long vendorCode;
    private String name;
    private ProductCategory category;
    private double unitPrice;
    private String manufacturer;
    private int quantity;
    private Timestamp createAt;
    private Timestamp modified;
    private Timestamp isDeleted;

    List<BasketDetails> basketDetails = new ArrayList<>();
}
