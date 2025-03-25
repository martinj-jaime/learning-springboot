package guru.springfamework.services;

import guru.springfamework.domain.Vendor;
import guru.springfamework.repositories.VendorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VendorService {
    private final VendorRepository vendorRepository;

    public VendorService(VendorRepository vendorRepository) {this.vendorRepository = vendorRepository;}

    public List<Vendor> findAll() { return this.vendorRepository.findAll(); }

    public Optional<Vendor> findById(Long id) { return this.vendorRepository.findById(id); }

    public Vendor save(Vendor vendor) { return this.vendorRepository.save(vendor); }


}
