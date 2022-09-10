package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import java.util.List;

public interface BasketDetailsService {

    BasketDetailsUIDto create(BasketDetailsRequestDto basketDetailsRequestDto);

    BasketDetailsUIDto updateById(BasketDetailsRequestDto basketDetailsRequestDto, long id);

    void deleteById(long id);

    BasketDetailsUIDto getById(long id);

    List<BasketDetailsUIDto> getAll();

    List<BasketDetailsUIDto> getAllByProduct(long productId);
}
