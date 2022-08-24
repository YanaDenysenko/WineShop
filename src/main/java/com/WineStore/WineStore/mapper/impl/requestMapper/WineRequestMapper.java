package com.WineStore.WineStore.mapper.impl.requestMapper;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Wine;
import com.WineStore.WineStore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
public class WineRequestMapper implements Mapper<Wine, WineRequestDto> {
    ProductService productService;

    @Override
    public WineRequestDto mapToDto(Wine wine) {
        return null;
    }

    @Override
    public Wine mapToModel(WineRequestDto wineRequestDto) {
        Wine wine = new Wine();
        wine.setProduct(productService.getById(wineRequestDto.getProductId()));
        wine.setColor(wineRequestDto.getColor());
        wine.setSweetness(wineRequestDto.getSweetness());
        wine.setRegion(wineRequestDto.getRegion());
        wine.setGrapeSort(wineRequestDto.getGrapeSort());
        wine.setClassification(wineRequestDto.getClassification());
        wine.setCapacity(wineRequestDto.getCapacity());
        return wine;
    }
}
