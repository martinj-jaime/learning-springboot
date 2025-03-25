package guru.springfamework.controllers;

import guru.springfamework.domain.Vendor;
import guru.springfamework.services.VendorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("${apiPrefix}/vendors")
public class VendorController {
    private VendorService vendorService;

    public VendorController(VendorService vendorService) { this.vendorService = vendorService; }

    @GetMapping
    public List<Vendor> listVendors() {
        return this.vendorService.findAll();
    }
}
