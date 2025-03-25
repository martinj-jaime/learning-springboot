package guru.springfamework.mapper;

import guru.springfamework.domain.Customer;
import guru.springfamework.dto.CustomerListDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Mapper
public interface CustomerListMapper {
    CustomerListMapper INSTANCE = Mappers.getMapper(CustomerListMapper.class);

    @Mapping(target = "name", expression = "java(customer.getFirstName() +  \" \"  + customer.getLastName())")
    CustomerListDTO customerToCustomerListDTO(Customer customer);
}
