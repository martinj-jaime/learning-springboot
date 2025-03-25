package guru.springfamework.controllers;

import guru.springfamework.converters.CustomerConverter;
import guru.springfamework.domain.Customer;
import guru.springfamework.dto.CustomerDTO;
import guru.springfamework.dto.CustomerListDTO;
import guru.springfamework.mapper.CustomerListMapper;
import guru.springfamework.services.CustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${apiPrefix}/customers")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) { this.customerService = customerService; }

    // region Map Struct Implementations
//    @GetMapping
//    public @ResponseBody ResponseEntity<List<CustomerListDTO>> listCustomersMapStruct() {
//        List<Customer> customers = this.customerService.findAll();
//
//        List<CustomerListDTO> customerListDTOS = customers.stream().
//                map(customer -> CustomerListMapper.INSTANCE.customerToCustomerListDTO(customer)).
//                collect(Collectors.toList());
//
//        return  new ResponseEntity<>(customerListDTOS, HttpStatus.OK);
//    }
    // endregion

    // region Custom Converters implementations
    @GetMapping
    public @ResponseBody
    ResponseEntity<List<CustomerListDTO>> listCustomers() {
        List<Customer> customers = this.customerService.findAll();
        if(customers == null) {
            return ResponseEntity.ok(Collections.emptyList());
        }
        List<CustomerListDTO> customerListDTOS = customers.stream().
                map(CustomerConverter::convertCustomerToCustomerListDTO).
                collect(Collectors.toList());
        return ResponseEntity.ok(customerListDTOS);
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<CustomerDTO> listCustomer(@PathVariable Long id) {
        Optional<Customer> customer = this.customerService.findById(id);
        CustomerDTO customerDTO;
        if(customer.isPresent()) {
            customerDTO = CustomerConverter.convertCustomerToCustomerDTO(customer.get());
            return ResponseEntity.ok(customerDTO);
        }
        return ResponseEntity.notFound().build();
    }
    // endregion

}
