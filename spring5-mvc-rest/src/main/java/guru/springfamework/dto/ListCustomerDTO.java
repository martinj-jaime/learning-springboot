package guru.springfamework.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class ListCustomerDTO {
    private Long id;
    private String name;

    public ListCustomerDTO() { }

    @Builder
    public ListCustomerDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
