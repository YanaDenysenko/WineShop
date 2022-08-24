package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.WineUIDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.Wine;

public class WineUIMapper implements Mapper<Wine, WineUIDto> {

    @Override
    public WineUIDto mapToDto(Wine wine) {
        return null;
    }

    @Override
    public Wine mapToModel(WineUIDto wineUIDto) {
        return null;
    }
}
