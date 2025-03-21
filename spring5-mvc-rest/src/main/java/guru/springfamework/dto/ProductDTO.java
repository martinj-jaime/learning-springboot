package guru.springfamework.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ProductDTO {
    private Long productId;
    private String name;
    private String price;

    public ProductDTO() {}

    @Builder
    public ProductDTO(Long productId, String name, String price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
}
