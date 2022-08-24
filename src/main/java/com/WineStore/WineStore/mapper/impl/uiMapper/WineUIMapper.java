package com.WineStore.WineStore.mapper.impl.uiMapper;

import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Wine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WineUIMapper implements Mapper<Wine, WineUIDto> {
    ProductUIMapper productUIMapper;

    @Override
    public WineUIDto mapToDto(Wine wine) {
        return WineUIDto.builder()
                .id(wine.getId())
                .productUIDto(productUIMapper.mapToDto(wine.getProduct()))
                .color(wine.getColor())
                .sweetness(wine.getSweetness())
                .region(wine.getRegion())
                .grapeSort(wine.getGrapeSort())
                .classification(wine.getClassification())
                .capacity(wine.getCapacity())
                .build();
    }

    @Override
    public Wine mapToModel(WineUIDto wineUIDto) {
        return null;
    }
}
