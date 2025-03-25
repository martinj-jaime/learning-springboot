package guru.springfamework.domain;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "order_table")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String state;
    private Long customer;
    private Double total;

    public Order() { }

    @Builder
    public Order(Long id, String state, Long customer, Double total) {
        this.id = id;
        this.state = state;
        this.customer = customer;
        this.total = total;
    }
}
