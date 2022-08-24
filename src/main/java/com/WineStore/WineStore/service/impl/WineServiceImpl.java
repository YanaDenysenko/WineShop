package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.exeption.WineNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.WineRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.WineUIMapper;
import com.WineStore.WineStore.model.Wine;
import com.WineStore.WineStore.repository.WineRepository;
import com.WineStore.WineStore.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@AllArgsConstructor
@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final WineRequestMapper wineRequestMapper;
    private final WineUIMapper wineUIMapper;

    @Override
    public WineUIDto create(WineRequestDto wineRequestDto) {
        return wineUIMapper.mapToDto(wineRepository.save(
                wineRequestMapper.mapToModel(wineRequestDto)));
    }

    @Override
    public Wine getById(long id) {
        return wineRepository.findById(id).orElseThrow(() -> new WineNotFoundException(id));
    }

    @Override
    public List<Wine> getAll() {
        return wineRepository.findAll();
    }
}
