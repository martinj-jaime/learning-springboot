package guru.springfamework.bootstrap;

import guru.springfamework.domain.Product;
import guru.springfamework.services.ProductService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Component
public class Bootstrap implements CommandLineRunner {

    private ProductService productService;

    public Bootstrap(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running from Bootstrap");
        this.loadData();
    }

    private void loadData() {
        // TODO: Ver como se puede refactorizar
        byte[] imageBytes = null;
        try {
            ClassPathResource resource = new ClassPathResource("images/grapes.jpg");
            if (resource.exists() && resource.isFile()) {
                File file = resource.getFile();
                imageBytes = Files.readAllBytes(Paths.get(file.getPath()));
            }
        } catch (IOException e) {
            System.out.println("No se pudo pre-cargar alguna imagen, error: " + e);
        }

        // #1 Product
        Product lemonFruitProduct = Product.builder().name("Limón").image(imageBytes).price(15.33).build();
        Product savedLemonFruitProduct = productService.save(lemonFruitProduct);

        // #2 Product
        Product appleFruitProduct = Product.builder().name("Manzana").price(30d).build();
        Product savedAppleFruitProduct = productService.save(appleFruitProduct);

    }
}
