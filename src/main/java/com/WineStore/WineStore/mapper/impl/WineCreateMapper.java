package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.WineCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Wine;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WineCreateMapper implements Mapper<Wine, WineCreateDto> {
    ProductService productService;

    @Override
    public WineCreateDto mapToDto(Wine wine) {
        return null;
    }

    @Override
    public Wine mapToModel(WineCreateDto wineCreateDto) {
        Wine wine = new Wine();
        wine.setProduct(productService.findById(wineCreateDto.getProductId()));
        wine.setColor(wineCreateDto.getColor());
        wine.setSweetness(wineCreateDto.getSweetness());
        wine.setRegion(wineCreateDto.getRegion());
        wine.setGrapeSort(wineCreateDto.getGrapeSort());
        wine.setClassification(wineCreateDto.getClassification());
        wine.setCapacity(wineCreateDto.getCapacity());
        return wine;
    }
}
