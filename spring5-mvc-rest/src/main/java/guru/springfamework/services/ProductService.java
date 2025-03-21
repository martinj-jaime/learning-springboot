package guru.springfamework.services;

import guru.springfamework.domain.Product;
import guru.springfamework.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public void deleteById(Long id) { productRepository.deleteById(id); }

    public void create(Product product) { productRepository.saveAndFlush(product); }

    public void update(Product product) { productRepository.saveAndFlush(product); }
}
