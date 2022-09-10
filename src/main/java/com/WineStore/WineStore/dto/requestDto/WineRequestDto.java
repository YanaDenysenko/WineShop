package com.WineStore.WineStore.dto.requestDto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WineRequestDto {
    private long productId;
    private String color;
    private String sweetness;
    private String region;
    private String grapeSort;
    private String classification;
    private double capacity;
}
