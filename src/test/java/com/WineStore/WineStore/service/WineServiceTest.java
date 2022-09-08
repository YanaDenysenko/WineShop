package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.WineRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.dto.uiDto.WineUIDto;
import com.WineStore.WineStore.exeption.WineNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.WineRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.WineUIMapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.model.Wine;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.repository.WineRepository;
import com.WineStore.WineStore.service.impl.WineServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WineServiceTest {

    @Mock
    WineRepository wineRepository;

    @Mock
    WineUIMapper wineUIMapper;

    @Mock
    WineRequestMapper wineRequestMapper;

    @Mock
    ProductRepository productRepository;

    @InjectMocks
    WineServiceImpl wineService;

    @Test
    public void createWine() {
        long id = 1;
        Wine mockWine = new Wine();
        WineUIDto mockWineUIDto = fillWineUIDto(id);
        WineRequestDto mockWineRequestDto = fillWineRequest();

        when(wineRequestMapper.mapToModel(mockWineRequestDto)).thenReturn(mockWine);
        when(wineRepository.save(mockWine)).thenReturn(mockWine);
        when(wineUIMapper.mapToDto(mockWine)).thenReturn(mockWineUIDto);

        Assert.assertEquals(mockWineUIDto, wineService.create(mockWineRequestDto));
    }

    @Test
    public void updateWineById() {
        long id = 1;
        Wine mockWine = new Wine();
        WineUIDto mockWineUIDto = fillWineUIDto(id);
        WineRequestDto mockWineRequestDto = fillWineRequest();

        when(wineUIMapper.mapToDto(mockWine)).thenReturn(mockWineUIDto);
        when(wineRepository.save(mockWine)).thenReturn(mockWine);
        when(wineRepository.findById(id)).thenReturn(Optional.of(mockWine));
        when(productRepository.findById(mockWineRequestDto.getProductId()))
                .thenReturn(Optional.of(new Product()));

        Assert.assertEquals(mockWineUIDto, wineService.updateById(mockWineRequestDto, id));
    }

    @Test
    public void deleteWineById() {
        long id = 1;
        Wine mockWine = new Wine();
        WineUIDto mockWineUIDto = fillWineUIDto(id);

        when(wineUIMapper.mapToDto(mockWine)).thenReturn(mockWineUIDto);
        when(wineRepository.save(mockWine)).thenReturn(mockWine);
        when(wineRepository.findById(id)).thenReturn(Optional.of(mockWine));

        Assert.assertEquals(mockWineUIDto, wineService.deleteById(id));
    }

    @Test
    public void getWineByCorrectId() {
        long id = 1;
        Wine mockWine = new Wine();
        WineUIDto mockWineUIDto = fillWineUIDto(id);

        when(wineRepository.findById(id)).thenReturn(Optional.of(mockWine));
        when(wineUIMapper.mapToDto(mockWine)).thenReturn(mockWineUIDto);

        Assert.assertEquals(mockWineUIDto, wineService.getById(id));
    }

    @Test(expected = WineNotFoundException.class)
    public void getWineByNonExistenceId() {
        wineService.getById(1);
    }

    //TODO when thenReturn
    @Test
    public void getAllWines() {
        List<WineUIDto> mockWineUIDtoList = fillWineUIDtoList();
        List<Wine> mockWines = new ArrayList<>();

        when(wineRepository.findAll()).thenReturn(mockWines);
        // ????

        List<WineUIDto> wineUIDtoList = wineService.getAll();

        IntStream.range(0, mockWineUIDtoList.size())
                .forEach(i -> Assert.assertEquals(mockWineUIDtoList.get(i), wineUIDtoList.get(i)));
    }

    private WineRequestDto fillWineRequest() {
        long productId = 1;
        String color = "color";
        String sweetness = "sweetness";
        String region = "region";
        String grapeSort = "grapeSort";
        String classification = "classification";
        double capacity = 1;

        return WineRequestDto.builder()
                .productId(productId)
                .color(color)
                .sweetness(sweetness)
                .region(region)
                .grapeSort(grapeSort)
                .classification(classification)
                .capacity(capacity)
                .build();
    }

    private WineUIDto fillWineUIDto(long id) {
        String color = "color";
        String sweetness = "sweetness";
        String region = "region";
        String grapeSort = "grapeSort";
        String classification = "classification";
        double capacity = 1;

        return WineUIDto.builder()
                .id(id)
                .productUIDto(ProductUIDto.builder().id(1).build())
                .color(color)
                .sweetness(sweetness)
                .region(region)
                .grapeSort(grapeSort)
                .classification(classification)
                .capacity(capacity)
                .build();
    }

    private List<WineUIDto> fillWineUIDtoList() {
        List<WineUIDto> wineUIDtoList = new ArrayList<>();
        wineUIDtoList.add(fillWineUIDto(1));
        wineUIDtoList.add(fillWineUIDto(2));
        return wineUIDtoList;
    }
}
