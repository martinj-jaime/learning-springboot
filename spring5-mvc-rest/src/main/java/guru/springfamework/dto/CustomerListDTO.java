package guru.springfamework.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomerListDTO {
    private Long id;
    private String name;

    public CustomerListDTO() { }

    @Builder
    public CustomerListDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
