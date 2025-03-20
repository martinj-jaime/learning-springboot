package guru.springfamework.bootstrap;

import guru.springfamework.domain.Product;
import guru.springfamework.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Bootstrap implements CommandLineRunner {

    private ProductService productService;

    public Bootstrap(ProductService productService) {this.productService = productService;}

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running from Bootstrap");
        this.loadData();
    }

    private void loadData() {
        // #1 Product
        Product lemonFruitProduct = Product.builder().name("Limón").price(15.33).build();
        Product savedLemonFruitProduct = productService.save(lemonFruitProduct);

        // #2 Product
        Product appleFruitProduct = Product.builder().name("Manzana").price(30d).build();
        Product savedAppleFruitProduct = productService.save(appleFruitProduct);

    }
}
