package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import java.util.List;

public interface WineService {

    WineUIDto create(WineRequestDto wineRequestDto);

    WineUIDto updateById(WineRequestDto wineRequestDto, long id);

    WineUIDto deleteById(long id);

    WineUIDto getById(long id);

    List<WineUIDto> getAll();
}
