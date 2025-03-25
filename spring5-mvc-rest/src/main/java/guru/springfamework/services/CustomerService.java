package guru.springfamework.services;

import guru.springfamework.domain.Customer;
import guru.springfamework.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> findAll() { return this.customerRepository.findAll(); }

    public Optional<Customer> findById(Long id) { return this.customerRepository.findById(id); }

    public Customer save(Customer customer) { return this.customerRepository.save(customer); }
}
