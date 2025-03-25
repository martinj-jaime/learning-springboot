package guru.springfamework.converters;

import guru.springfamework.domain.Vendor;
import guru.springfamework.dto.VendorDTO;

public abstract class VendorConverter {

    public static VendorDTO convertVendorToVendorDTO(Vendor vendor) {
        VendorDTO vendorDTO = new VendorDTO();

        vendorDTO.setId(vendor.getId());
        vendorDTO.setName(vendor.getName());

        return vendorDTO;
    }

}
