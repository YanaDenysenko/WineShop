package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.BasketDetailsRequestDto;
import com.WineStore.WineStore.dto.uiDto.BasketDetailsUIDto;
import com.WineStore.WineStore.model.BasketDetails;
import java.util.List;

public interface BasketDetailsService {

    BasketDetailsUIDto create(BasketDetailsRequestDto basketDetailsRequestDto);

    BasketDetails getById(long id);

    List<BasketDetails> getAll();

    List<BasketDetails> getAllByProduct(long productId);
}
