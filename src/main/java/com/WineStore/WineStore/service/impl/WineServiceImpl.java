package com.WineStore.WineStore.service.impl;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.exeption.ProductNotFoundException;
import com.WineStore.WineStore.exeption.WineNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.WineRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.WineUIMapper;
import com.WineStore.WineStore.model.Wine;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.repository.WineRepository;
import com.WineStore.WineStore.service.WineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class WineServiceImpl implements WineService {
    private final WineRepository wineRepository;
    private final WineRequestMapper wineRequestMapper;
    private final WineUIMapper wineUIMapper;
    private final ProductRepository productRepository;

    @Override
    public WineUIDto create(WineRequestDto wineRequestDto) {
        return wineUIMapper.mapToDto(wineRepository.save(
                wineRequestMapper.mapToModel(wineRequestDto)));
    }

    @Override
    public WineUIDto updateById(WineRequestDto wineRequestDto, long id) {
        long productId = wineRequestDto.getProductId();
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));

        wine.setProduct(productRepository.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId)));
        wine.setColor(wineRequestDto.getColor());
        wine.setSweetness(wineRequestDto.getSweetness());
        wine.setRegion(wineRequestDto.getRegion());
        wine.setGrapeSort(wineRequestDto.getGrapeSort());
        wine.setClassification(wineRequestDto.getClassification());
        wine.setCapacity(wineRequestDto.getCapacity());
        wine.setModified(new Timestamp(System.currentTimeMillis()));

        return wineUIMapper.mapToDto(wineRepository.save(wine));
    }

    @Override
    public WineUIDto deleteById(long id) {
        Wine wine = wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id));

        wine.setDeleted(true);
        wine.setModified(new Timestamp(System.currentTimeMillis()));

        return wineUIMapper.mapToDto(wineRepository.save(wine));
    }

    @Override
    public WineUIDto getById(long id) {
        return wineUIMapper.mapToDto(wineRepository.findById(id)
                .orElseThrow(() -> new WineNotFoundException(id)));
    }

    @Override
    public List<WineUIDto> getAll() {
        return wineRepository.findAll().stream()
                .map(wineUIMapper::mapToDto)
                .collect(Collectors.toList());
    }
}
