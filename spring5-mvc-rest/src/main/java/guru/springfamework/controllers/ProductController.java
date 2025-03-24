package guru.springfamework.controllers;

import guru.springfamework.domain.Product;
import guru.springfamework.dto.ProductDTO;
import guru.springfamework.mapper.ProductMapper;
import guru.springfamework.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
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
    public @ResponseBody ResponseEntity<List<ProductDTO>> listProducts() {
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(productMapper.productsToProductDTOs(products), HttpStatus.OK);
    }

    @PostMapping("/add")
    public void addProduct(@RequestBody ProductDTO productDTO) {
        Product product = productMapper.productDTOToProduct(productDTO);
        productService.create(product);
    }

    @GetMapping("/{id}")
    public @ResponseBody ResponseEntity<ProductDTO> listProduct(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
         if(product.isPresent()) {
            return new ResponseEntity<>(productMapper.productToProductDTO(product.get()), HttpStatus.OK);
         }
        return null;
    }

    @PutMapping("/{id}")
    public void updateOne(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productDTO.setProductId(id);
        Product product = productMapper.productDTOToProduct(productDTO);
        productService.update(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOne(@PathVariable Long id) {
        try {
            productService.deleteById(id);
            return ResponseEntity.ok(HttpStatus.OK);
        } catch(Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product with ID " + id + "couldn't be deleted");
        }
    }

    @GetMapping(value = "/{id}/image", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] listImage(@PathVariable Long id) {
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()) {
            return product.get().getImage();
        }
        return null;
    }
}
