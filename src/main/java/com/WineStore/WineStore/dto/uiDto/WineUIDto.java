package com.WineStore.WineStore.dto.uiDto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class WineUIDto {
    private long id;
    private ProductUIDto productUIDto;
    private String color;
    private String sweetness;
    private String region;
    private String grapeSort;
    private String classification;
    private double capacity;
}
