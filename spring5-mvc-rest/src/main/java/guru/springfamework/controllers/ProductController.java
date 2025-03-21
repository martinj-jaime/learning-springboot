package guru.springfamework.controllers;

import guru.springfamework.domain.Product;
import guru.springfamework.dto.ProductDTO;
import guru.springfamework.mapper.ProductMapper;
import guru.springfamework.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;

    public ProductController(ProductService productService, ProductMapper productMapper) {
        this.productService = productService;
        this.productMapper = productMapper;
    }

    @GetMapping
    public @ResponseBody List<ProductDTO> apiGetProducts() {
        List<Product> products = productService.findAll();
        return productMapper.productsToProductDTOs(products);
    }

    @GetMapping("/{id}")
    public @ResponseBody ProductDTO apiGetProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            return productMapper.productToProductDTO(product.get());
        }
        return null;
    }
}
