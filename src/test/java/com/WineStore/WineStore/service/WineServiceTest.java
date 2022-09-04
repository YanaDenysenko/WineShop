package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.WineNotFoundException;
import com.WineStore.WineStore.model.Wine;
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
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class WineServiceTest {

    @Mock
    WineRepository wineRepository;

    @InjectMocks
    WineServiceImpl wineService;

    @Test
    public void createWine(){
    }

    @Test
    public void getWineByCorrectId(){
        long id = 1;
        String color = "color";
        String sweetness = "sweetness";
        String region = "region";
        String grapeSort = "grapeSort";
        String classification = "classification";
        double capacity = 1;

        when(wineRepository.findById(id)).thenReturn(
                fillWine(id, color, sweetness, region, grapeSort, classification, capacity));
        Assert.assertEquals(id, wineService.getById(id).getId());
        Assert.assertEquals(color, wineService.getById(id).getColor());
        Assert.assertEquals(sweetness, wineService.getById(id).getSweetness());
        Assert.assertEquals(region, wineService.getById(id).getRegion());
        Assert.assertEquals(grapeSort, wineService.getById(id).getGrapeSort());
        Assert.assertEquals(classification, wineService.getById(id).getClassification());

    }

    @Test(expected = WineNotFoundException.class)
    public void getWineByNonExistenceId(){
        wineService.getById(1);
    }

    @Test
    public void getAllWines(){
    }

    private Optional<Wine> fillWine(long id, String color, String sweetness, String region, String grapeSort,
                                    String classification, double capacity){
        Wine wine = new Wine();
        wine.setId(id);
        wine.setColor(color);
        wine.setSweetness(sweetness);
        wine.setRegion(region);
        wine.setGrapeSort(grapeSort);
        wine.setClassification(classification);
        wine.setCapacity(capacity);
        return Optional.of(wine);
    }

    private List<Wine> fillWineList(){
        List<Wine> wineList = new ArrayList<>();
        wineList.add(fillWine(1, "color1", "sweetness1", "region1",
                "grapeSort1", "classification1", 1).get());
        wineList.add(fillWine(2, "color2", "sweetness2", "region2",
                "grapeSort2", "classification2", 2).get());
        return wineList;
    }
}
