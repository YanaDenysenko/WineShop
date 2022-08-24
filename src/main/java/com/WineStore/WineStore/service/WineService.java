package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.WineCreateDto;
import com.WineStore.WineStore.dto.WineUIDto;

public interface WineService {
    WineUIDto create(WineCreateDto wineCreateDto);
}
