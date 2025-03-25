package guru.springfamework.dto;

import lombok.Builder;
import lombok.Data;

@Data
public class CustomerDTO {
    private String firstname;
    private String lastname;

    public CustomerDTO() { }

    @Builder
    public CustomerDTO(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }
}
