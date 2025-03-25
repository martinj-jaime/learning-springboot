package guru.springfamework.controllers;

import guru.springfamework.domain.Customer;
import guru.springfamework.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    @GetMapping
    public List<Customer> listCustomers() {
        return this.customerService.findAll();
    }

}
