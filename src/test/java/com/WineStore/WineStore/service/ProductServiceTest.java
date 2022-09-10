package com.WineStore.WineStore.service;

import com.WineStore.WineStore.dto.requestDto.ProductRequestDto;
import com.WineStore.WineStore.dto.uiDto.ProductCategoryUIDto;
import com.WineStore.WineStore.dto.uiDto.ProductUIDto;
import com.WineStore.WineStore.exeption.ProductNotFoundException;
import com.WineStore.WineStore.mapper.impl.requestMapper.ProductRequestMapper;
import com.WineStore.WineStore.mapper.impl.uiMapper.ProductUIMapper;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.model.ProductCategory;
import com.WineStore.WineStore.repository.ProductCategoryRepository;
import com.WineStore.WineStore.repository.ProductRepository;
import com.WineStore.WineStore.service.impl.ProductServiceImpl;
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
public class ProductServiceTest {

    @Mock
    ProductRepository productRepository;

    @Mock
    ProductUIMapper productUIMapper;

    @Mock
    ProductRequestMapper productRequestMapper;

    @Mock
    ProductCategoryRepository productCategoryRepository;

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void createProduct() {
        long id = 1;
        Product mockProduct = new Product();
        ProductUIDto mockProductUIDto = fillProductUIDto(id);
        ProductRequestDto mockProductRequestDto = fillProductRequestDto();

        when(productRepository.save(mockProduct)).thenReturn(mockProduct);
        when(productUIMapper.mapToDto(mockProduct)).thenReturn(mockProductUIDto);
        when(productRequestMapper.mapToModel(mockProductRequestDto)).thenReturn(mockProduct);

        Assert.assertEquals(mockProductUIDto, productService.create(mockProductRequestDto));
    }

    @Test
    public void updateProductById() {
        long id = 1;
        Product mockProduct = new Product();
        ProductUIDto mockProductUIDto = fillProductUIDto(id);
        ProductRequestDto mockProductRequestDto = fillProductRequestDto();

        when(productRepository.save(mockProduct)).thenReturn(mockProduct);
        when(productRepository.findById(id)).thenReturn(Optional.of(mockProduct));
        when(productUIMapper.mapToDto(mockProduct)).thenReturn(mockProductUIDto);
        when(productCategoryRepository.findById(mockProductRequestDto.getProductCategoryId()))
                .thenReturn(Optional.of(new ProductCategory()));

        Assert.assertEquals(mockProductUIDto, productService.updateById(mockProductRequestDto, id));
    }

    @Test
    public void deleteProductById() {
        long id = 1;
        Product mockProduct = new Product();
        ProductUIDto mockProductUIDto = fillProductUIDto(id);

        when(productRepository.save(mockProduct)).thenReturn(mockProduct);
        when(productRepository.findById(id)).thenReturn(Optional.of(mockProduct));
        when(productUIMapper.mapToDto(mockProduct)).thenReturn(mockProductUIDto);

        Assert.assertEquals(mockProductUIDto, productService.deleteById(id));
    }

    @Test
    public void getProductByCorrectId() {
        long id = 1;
        Product mockProduct = new Product();
        ProductUIDto mockProductUIDto = fillProductUIDto(id);

        when(productRepository.findById(id)).thenReturn(Optional.of(mockProduct));
        when(productUIMapper.mapToDto(mockProduct)).thenReturn(mockProductUIDto);

        Assert.assertEquals(mockProductUIDto, productService.getById(id));
    }

    @Test(expected = ProductNotFoundException.class)
    public void getProductByNonExistenceId() {
        productService.getById(1);
    }

    @Test
    public void getAllProducts() {
    }

    @Test
    public void getProductsByManufacturer() {
    }

    @Test
    public void getAvailableProducts() {
    }

    @Test
    public void getProductsByOrderId() {
    }

    @Test
    public void getProductsByCategoryId() {
    }

    private Optional<Product> fillProduct(long id, long vendorCode, String name,
                                          double unitPrice, String manufacture, int quantity) {
        Product product = new Product();
        product.setId(id);
        product.setVendorCode(vendorCode);
        product.setName(name);
        product.setUnitPrice(unitPrice);
        product.setManufacturer(manufacture);
        product.setQuantity(quantity);
        return Optional.of(product);
    }

    private ProductUIDto fillProductUIDto(long id) {
        long vendorCode = 111;
        String name = "name";
        double unitPrice = 111;
        String manufacture = "manufacture";
        int quantity = 111;

        return ProductUIDto.builder()
                .id(id)
                .vendorCode(vendorCode)
                .name(name)
                .productCategoryUIDto(ProductCategoryUIDto.builder().id(1).build())
                .unitPrice(unitPrice)
                .manufacturer(manufacture)
                .quantity(quantity)
                .build();
    }

    private ProductRequestDto fillProductRequestDto() {
        long vendorCode = 111;
        String name = "name";
        double unitPrice = 111;
        String manufacture = "manufacture";
        int quantity = 111;

        return ProductRequestDto.builder()
                .vendorCode(vendorCode)
                .name(name)
                .productCategoryId(1)
                .unitPrice(unitPrice)
                .manufacturer(manufacture)
                .quantity(quantity)
                .build();
    }

    private List<ProductUIDto> fillProductUIDtoList() {
        List<ProductUIDto> productUIDtoList = new ArrayList<>();
        productUIDtoList.add(fillProductUIDto(1));
        productUIDtoList.add(fillProductUIDto(2));
        return productUIDtoList;
    }
}
