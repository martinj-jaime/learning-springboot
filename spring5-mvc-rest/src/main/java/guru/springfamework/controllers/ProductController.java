package guru.springfamework.controllers;

import guru.springfamework.domain.Product;
import guru.springfamework.dto.ProductDTO;
import guru.springfamework.services.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {this.productService = productService;}

    @GetMapping
    public @ResponseBody List<ProductDTO> apiGetProducts() {
        List<Product> products = productService.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        for(Product p : products) {
            productsDTO.add(ProductDTO.builder()
                    .id(p.getId())
                    .price(String.valueOf(p.getPrice()))
                    .name(p.getName())
                    .build()
            );
        }
        return productsDTO;
    }

    @GetMapping("/{id}")
    public @ResponseBody ProductDTO apiGetProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            ProductDTO productDTO = ProductDTO.builder()
                    .id(product.get().getId())
                    .name(product.get().getName())
                    .price(String.valueOf(product.get().getPrice()))
                    .build();
            return productDTO;
        }
        return null;
    }
}
