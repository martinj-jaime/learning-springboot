package guru.springfamework.bootstrap;

import guru.springfamework.domain.Customer;
import guru.springfamework.domain.Order;
import guru.springfamework.domain.Product;
import guru.springfamework.domain.Vendor;
import guru.springfamework.services.CustomerService;
import guru.springfamework.services.OrderService;
import guru.springfamework.services.ProductService;
import guru.springfamework.services.VendorService;
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
    private CustomerService customerService;
    private VendorService vendorService;
    private OrderService orderService;

    public Bootstrap(ProductService productService, CustomerService customerService,
            OrderService orderService, VendorService vendorService) {
        this.productService = productService;
        this.customerService = customerService;
        this.vendorService = vendorService;
        this.orderService = orderService;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Running from Bootstrap");
        this.loadData();
    }

    private void loadData() {
        this.loadCustomers();
        this.loadVendors();
        this.loadOrders();

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

    private void loadProducts() {  }

    private void loadCustomers() {
        Customer customer1 = Customer.builder().firstName("Helen").lastName("Andrus").build();
        Customer savedCustomer = customerService.save(customer1);

        Customer customer2 = Customer.builder().firstName("Larry").lastName("Lawson").build();
        Customer savedCustomer2 = customerService.save(customer2);
    }

    private void loadOrders() {
        Order order = Order.builder().state("CREATED").customer(1L).build();
        Order savedOrder = orderService.save(order);
    }

    private void loadVendors() {
        Vendor vendor = Vendor.builder().name("Exotics Fruit Lair Ltd.").build();
        Vendor savedVendor = vendorService.save(vendor);

        Vendor vendor2 = Vendor.builder().name("Max Obsthof GmbH").build();
        Vendor savedVendor2 = vendorService.save(vendor2);
    }
}
