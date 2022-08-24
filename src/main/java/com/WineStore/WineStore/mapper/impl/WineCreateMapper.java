package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.WineCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Wine;
import org.springframework.stereotype.Component;

@Component
public class WineCreateMapper implements Mapper<Wine, WineCreateDto> {

    @Override
    public WineCreateDto mapToDto(Wine wine) {
        return null;
    }

    @Override
    public Wine mapToModel(WineCreateDto wineCreateDto) {
        return null;
    }
}
