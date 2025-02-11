package com.example.services;
import com.example.model.Owner;
import org.springframework.data.repository.CrudRepository;

public interface OwnerService extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}
