package guru.springfamework.controllers;

import guru.springfamework.domain.Product;
import guru.springfamework.dto.ProductDTO;
import guru.springfamework.services.ProductService;
import org.junit.Before;
import org.junit.Test;
 import org.junit.Assert;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class ProductControllerTest {

    @Mock
    private ProductService productService;

    @InjectMocks
    private ProductController productController;

    List<Product> products;

    @Before
    public void setUp() throws Exception {
        this.products = new ArrayList<>();
        this.products.add(Product.builder().id(1L).name("apple").price(15d).build());
        this.products.add(Product.builder().id(2L).name("banana").build());
        Mockito.when(productService.findAll()).thenReturn(this.products);
        Mockito.when(productService.findById(1L)).thenReturn(Optional.of(this.products.get(0)));
    }

    @Test
    public void apiGetProducts() {
        List<ProductDTO> products = productController.apiGetProducts();
        Assert.assertEquals(2, products.size());
    }

    @Test
    public void apiGetProduct() {
        ProductDTO product = productController.apiGetProduct(1L);
        Assert.assertEquals("apple", product.getName());
    }
}