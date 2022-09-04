package com.WineStore.WineStore.service;

import com.WineStore.WineStore.exeption.ProductNotFoundException;
import com.WineStore.WineStore.model.Product;
import com.WineStore.WineStore.model.ProductCategory;
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

    @InjectMocks
    ProductServiceImpl productService;

    @Test
    public void createProduct(){
    }

    @Test
    public void getProductByCorrectId(){
        long id = 1;
        long vendorCode = 111;
        String name = "name";
        double unitPrice = 111;
        String manufacture = "manufacture";
        int quantity = 111;

        when(productRepository.findById(id)).thenReturn(fillProduct(
                id, vendorCode, name, unitPrice, manufacture, quantity));
        Assert.assertEquals(id, productService.getById(id).getId());
        Assert.assertEquals(vendorCode, productService.getById(id).getVendorCode());
        Assert.assertEquals(name, productService.getById(id).getName());
        Assert.assertEquals(manufacture, productService.getById(id).getManufacturer());
        Assert.assertEquals(quantity, productService.getById(id).getQuantity());

    }

    @Test(expected = ProductNotFoundException.class)
    public void getProductByNonExistenceId(){
        productService.getById(1);
    }

    @Test
    public void getAllProducts(){
    }

    @Test
    public void getProductsByManufacturer(){
    }

    @Test
    public void getAvailableProducts(){
    }

    @Test
    public void getProductsByOrderId(){
    }

    @Test
    public void getProductsByCategoryId(){
    }

    private Optional<Product> fillProduct(long id, long vendorCode, String name,
                                          double unitPrice, String manufacture, int quantity){
        Product product = new Product();
        product.setId(id);
        product.setVendorCode(vendorCode);
        product.setName(name);
        product.setUnitPrice(unitPrice);
        product.setManufacturer(manufacture);
        product.setQuantity(quantity);
        return Optional.of(product);
    }

    private Optional<ProductCategory> fillProductCategory(long id, String name){
        ProductCategory productCategory = new ProductCategory();
        productCategory.setId(id);
        productCategory.setName(name);
        return Optional.of(productCategory);
    }

    private List<Product> fillProductList(){
        List<Product> productList = new ArrayList<>();
        productList.add(fillProduct(
                1, 1, "name1", 111, "Manufacturer1", 1).get());
        productList.add(fillProduct(
                2, 2, "name2", 222, "Manufacturer2", 2).get());
        return productList;
    }
}
