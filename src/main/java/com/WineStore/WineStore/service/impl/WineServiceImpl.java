package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.WineCreateDto;
import com.WineStore.WineStore.dto.WineUIDto;
import com.WineStore.WineStore.mapper.impl.WineCreateMapper;
import com.WineStore.WineStore.mapper.impl.WineUIMapper;
import com.WineStore.WineStore.repository.WineRepository;
import com.WineStore.WineStore.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final WineCreateMapper wineCreateMapper;
    private final WineUIMapper wineUIMapper;

    @Override
    public WineUIDto create(WineCreateDto wineCreateDto) {
        return wineUIMapper.mapToDto(wineRepository.save(
                wineCreateMapper.mapToModel(wineCreateDto)));
    }
}
