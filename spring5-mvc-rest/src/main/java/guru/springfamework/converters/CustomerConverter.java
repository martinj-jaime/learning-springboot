package guru.springfamework.converters;

import guru.springfamework.domain.Customer;
import guru.springfamework.dto.CustomerDTO;
import guru.springfamework.dto.CustomerListDTO;

public abstract class CustomerConverter {

    public static CustomerDTO convertCustomerToCustomerDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();

        customerDTO.setFirstname(customer.getFirstName());
        customerDTO.setLastname(customer.getLastName());

        return customerDTO;
    }

    public static CustomerListDTO convertCustomerToCustomerListDTO(Customer customer) {
        CustomerListDTO customerListDTO = new CustomerListDTO();

        customerListDTO.setId(customer.getId());
        customerListDTO.setName(customer.getFirstName() + " " + customer.getLastName());

        return customerListDTO;
    }

}
