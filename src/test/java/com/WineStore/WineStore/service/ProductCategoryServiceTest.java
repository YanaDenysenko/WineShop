package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.ProductCategoryNotFoundException;
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

    @InjectMocks
    ProductCategoryServiceImpl productCategoryService;

    @Test
    public void createProductCategory(){
    }

    @Test
    public void getProductCategoryByCorrectId(){
        long id = 1;
        String name = "categoryName";

        when(productCategoryRepository.findById(id)).thenReturn(fillProductCategory(id, name));
        Assert.assertEquals(id, productCategoryService.getById(id).getId());
        Assert.assertEquals(name, productCategoryService.getById(id).getName());
    }

    @Test(expected = ProductCategoryNotFoundException.class)
    public void getProductCategoryByNonExistenceId(){
        productCategoryService.getById(1);
    }

    @Test
    public void getAllProductCategories(){
    }

    @Test
    public void getProductCategoryByCorrectName(){
        long id = 1;
        String name = "categoryName";

        when(productCategoryRepository.getByName(name)).thenReturn(fillProductCategory(id, name));
        Assert.assertEquals(id, productCategoryService.getByName(name).getId());
        Assert.assertEquals(name, productCategoryService.getByName(name).getName());
    }

    @Test(expected = ProductCategoryNotFoundException.class)
    public void getProductCategoryByNonExistenceName(){
        productCategoryService.getByName("");
    }

    private Optional<ProductCategory> fillProductCategory(long id, String name){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);
        return Optional.of(productCategory);
    }

    private List<ProductCategory> fillProductCategoryList(){
        List<ProductCategory> productCategoryList = new ArrayList<>();
        productCategoryList.add(fillProductCategory(1, "name1").get());
        productCategoryList.add(fillProductCategory(2, "name2").get());
        return productCategoryList;
    }
}
