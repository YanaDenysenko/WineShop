package com.WineStore.WineStore.mapper.impl;

import com.WineStore.WineStore.dto.BasketDetailsCreateDto;
import com.WineStore.WineStore.mapper.Mapper;
import com.WineStore.WineStore.model.BasketDetails;
import org.springframework.stereotype.Component;

@Component
public class BasketDetailsCreateMapper implements Mapper<BasketDetails, BasketDetailsCreateDto> {

    @Override
    public BasketDetailsCreateDto mapToDto(BasketDetails basketDetails) {
        return null;
    }

    @Override
    public BasketDetails mapToModel(BasketDetailsCreateDto basketDetailsCreateDto) {
        return null;
    }
}
