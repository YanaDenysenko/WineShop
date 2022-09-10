package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.ProductCategoryRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import com.WineStore.WineStore.exeption.ProductCategoryNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.ProductCategoryRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductCategoryUIMapper;
import com.WineStore.WineStore.model.ProductCategory;
import com.WineStore.WineStore.repository.ProductCategoryRepository;
import com.WineStore.WineStore.service.impl.ProductCategoryServiceImpl;
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
public class ProductCategoryServiceTest {

    @Mock
    ProductCategoryRepository productCategoryRepository;

    @Mock
    ProductCategoryUIMapper productCategoryUIMapper;

    @Mock
    ProductCategoryRequestMapper productCategoryRequestMapper;

    @InjectMocks
    ProductCategoryServiceImpl productCategoryService;

    @Test
    public void createProductCategory(){
        long id = 1;
        ProductCategory mockProductCategory = new ProductCategory();
        ProductCategoryUIDto mockProductCategoryUIDto = fillProductCategoryUIDto(id);
        ProductCategoryRequestDto mockProductCategoryRequestDto = fillProductCategoryRequestDto();

        when(productCategoryRepository.save(mockProductCategory)).thenReturn(mockProductCategory);
        when(productCategoryUIMapper.mapToDto(mockProductCategory))
                .thenReturn(mockProductCategoryUIDto);
        when(productCategoryRequestMapper.mapToModel(mockProductCategoryRequestDto))
                .thenReturn(mockProductCategory);

        Assert.assertEquals(mockProductCategoryUIDto,
                productCategoryService.create(mockProductCategoryRequestDto));
    }

    @Test
    public void updateProductCategoryById() {
        long id = 1;
        ProductCategory mockProductCategory = new ProductCategory();
        ProductCategoryUIDto mockProductCategoryUIDto = fillProductCategoryUIDto(id);
        ProductCategoryRequestDto mockProductCategoryRequestDto = fillProductCategoryRequestDto();

        when(productCategoryRepository.save(mockProductCategory)).thenReturn(mockProductCategory);
        when(productCategoryRepository.findById(id)).thenReturn(Optional.of(mockProductCategory));
        when(productCategoryUIMapper.mapToDto(mockProductCategory))
                .thenReturn(mockProductCategoryUIDto);

        Assert.assertEquals(mockProductCategoryUIDto,
                productCategoryService.updateById(mockProductCategoryRequestDto, id));
    }

    @Test
    public void deleteProductCategoryById() {
        long id = 1;
        ProductCategory mockProductCategory = new ProductCategory();
        ProductCategoryUIDto mockProductCategoryUIDto = fillProductCategoryUIDto(id);

        when(productCategoryRepository.save(mockProductCategory)).thenReturn(mockProductCategory);
        when(productCategoryRepository.findById(id)).thenReturn(Optional.of(mockProductCategory));
        when(productCategoryUIMapper.mapToDto(mockProductCategory))
                .thenReturn(mockProductCategoryUIDto);

        Assert.assertEquals(mockProductCategoryUIDto,
                productCategoryService.deleteById(id));
    }

    @Test
    public void getProductCategoryByCorrectId() {
        long id = 1;
        ProductCategory mockProductCategory = new ProductCategory();
        ProductCategoryUIDto mockProductCategoryUIDto = fillProductCategoryUIDto(id);

        when(productCategoryRepository.findById(id)).thenReturn(Optional.of(mockProductCategory));
        when(productCategoryUIMapper.mapToDto(mockProductCategory))
                .thenReturn(mockProductCategoryUIDto);

        Assert.assertEquals(mockProductCategoryUIDto,
                productCategoryService.getById(id));
    }

    @Test(expected = ProductCategoryNotFoundException.class)
    public void getProductCategoryByNonExistenceId() {
        productCategoryService.getById(1);
    }

    @Test
    public void getAllProductCategories() {
    }

    @Test
    public void getProductCategoryByCorrectName() {
        long id = 1;
        String name = "name";
        ProductCategory mockProductCategory = new ProductCategory();
        ProductCategoryUIDto mockProductCategoryUIDto = fillProductCategoryUIDto(id);

        when(productCategoryRepository.getByName(name)).thenReturn(Optional.of(mockProductCategory));
        when(productCategoryUIMapper.mapToDto(mockProductCategory))
                .thenReturn(mockProductCategoryUIDto);

        Assert.assertEquals(mockProductCategoryUIDto,
                productCategoryService.getByName(name));
    }

    @Test(expected = ProductCategoryNotFoundException.class)
    public void getProductCategoryByNonExistenceName() {
        productCategoryService.getByName("");
    }

    private ProductCategoryUIDto fillProductCategoryUIDto(long id) {
        return ProductCategoryUIDto.builder()
                .id(id)
                .name("name")
                .build();
    }

    private ProductCategoryRequestDto fillProductCategoryRequestDto() {
        return ProductCategoryRequestDto.builder()
                .name("name")
                .build();
    }

    private List<ProductCategoryUIDto> fillProductCategoryUIDtoList(){
        List<ProductCategoryUIDto> productCategoryUIDtoList = new ArrayList<>();
        productCategoryUIDtoList.add(fillProductCategoryUIDto(1));
        productCategoryUIDtoList.add(fillProductCategoryUIDto(2));
        return productCategoryUIDtoList;
    }
}
