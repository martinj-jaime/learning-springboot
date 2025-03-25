package guru.springfamework.controllers;

import guru.springfamework.converters.VendorConverter;
import guru.springfamework.domain.Vendor;
import guru.springfamework.dto.VendorDTO;
import guru.springfamework.services.VendorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${apiPrefix}/vendors")
public class VendorController {
    private VendorService vendorService;

    public VendorController(VendorService vendorService) { this.vendorService = vendorService; }

    @GetMapping
    public List<VendorDTO> listVendors() {
        List<Vendor> vendors = this.vendorService.findAll();
        List<VendorDTO> vendorsDTO = vendors.stream().
                map(VendorConverter::convertVendorToVendorDTO).
                collect(Collectors.toList());
        return vendorsDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<VendorDTO> listVendor(@PathVariable Long id) {
        Optional<Vendor> vendor = this.vendorService.findById(id);
        if(vendor.isPresent()) {
            VendorDTO vendorDTO = VendorConverter.convertVendorToVendorDTO(vendor.get());
            return ResponseEntity.ok(vendorDTO);
        }
        return ResponseEntity.notFound().build();
    }

    // @GetMapping("/{id}/products")
    // public ResponseEntity




}
