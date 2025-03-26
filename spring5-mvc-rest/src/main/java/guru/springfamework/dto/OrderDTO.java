package guru.springfamework.dto;

import lombok.Builder;
import lombok.Data;

// TODO refactor endpoint response
//    {
//            "id": 4,
//            "state": "CREATED",
//            "items": [
//              {
//                  "product_id": 3,
//                  "quantity": 12
//              },
//              {
//                  "product_id": 5,
//                  "quantity": 7
//              }
//            ],

@Data
public class OrderDTO {
    private Long id;
    private String state;
    private Long product_id;
    private Long quantity;
    private CustomerDTO customer;

    public OrderDTO() { }

    @Builder
    public OrderDTO(Long id, String state, Long product_id,
            Long quantity, CustomerDTO customer
            ) {
        this.id = id;
        this.state = state;
        this.product_id = product_id;
        this.quantity = quantity;
        this.customer = customer;
    }
}
