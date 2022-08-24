package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.model.Wine;
import java.util.List;

public interface WineService {

    WineUIDto create(WineRequestDto wineRequestDto);

    Wine getById(long id);

    List<Wine> getAll();
}
